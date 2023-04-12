package com.slack.chatgpt.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slack.chatgpt.dto.chatgpt.ChatGPTResponse;
import com.slack.chatgpt.service.ChatGPTService;
import com.slack.chatgpt.service.SlackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SlackServiceImpl implements SlackService {

    @Value("${slack.token}")
    private String slackToken;

    private final RestTemplate restTemplate;
    private final ChatGPTService chatGPTService;

    private static final String SLACK_POST_MESSAGE_URL = "https://slack.com/api/chat.postMessage";

    @Async("ThreadPoolTaskExecutor")
    public void sendChatGPTMessageToChannel(String channelId, String question) {
        HttpHeaders headers = getSlackHeaders(slackToken);

        try {
            ChatGPTResponse chatGPTResponse = chatGPTService.getChatGPTResponse(question);
            String body = getJsonBody(channelId, chatGPTResponse.getChoices().get(0).getMessage().getContent());
            restTemplate.exchange(SLACK_POST_MESSAGE_URL, HttpMethod.POST, new HttpEntity<>(body, headers), String.class);
        } catch (Exception e) {
            restTemplate.exchange(SLACK_POST_MESSAGE_URL, HttpMethod.POST, new HttpEntity<>("실패", headers), String.class);
        }
    }

    private HttpHeaders getSlackHeaders(String slackToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + slackToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private String getJsonBody(String channelId, String text) throws JsonProcessingException {
        Map<String, String> jsonObject = new HashMap<>();
        jsonObject.put("channel", channelId);
        jsonObject.put("text", text);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonObject);
    }


}
