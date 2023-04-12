package com.slack.chatgpt.service.impl;

import com.slack.chatgpt.dto.chatgpt.ChatGPTRequest;
import com.slack.chatgpt.dto.chatgpt.ChatGPTResponse;
import com.slack.chatgpt.dto.chatgpt.Message;
import com.slack.chatgpt.service.ChatGPTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatGPTServiceImpl implements ChatGPTService {

    @Value("${chatgpt.apikey}")
    private String apiKey;
    @Value("${chatgpt.url.chat}")
    private String chatUrl;

    private final RestTemplate restTemplate;

    public ChatGPTResponse getChatGPTResponse(String prompt) {
        HttpHeaders headers = getChatGPTHerders(apiKey);
        ChatGPTRequest chatGPTRequest = getChatGPTRequest(prompt);
        HttpEntity<ChatGPTRequest> request = new HttpEntity<>(chatGPTRequest, headers);
        return restTemplate.postForObject(chatUrl, request, ChatGPTResponse.class);
    }

    private ChatGPTRequest getChatGPTRequest(String prompt) {
        ChatGPTRequest chatGPTRequest = new ChatGPTRequest();
        chatGPTRequest.setModel("gpt-3.5-turbo"); // Most capable GPT-3.5 model and optimized for chat.
        chatGPTRequest.setMessages(List.of(new Message("user", prompt))); // Input prompt for ChatGPT
        chatGPTRequest.setMax_tokens(1000); // The maximum number of tokens to generate in the chat completion.
        return chatGPTRequest;
    }

    private HttpHeaders getChatGPTHerders(String apiKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
        return headers;
    }
}
