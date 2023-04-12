package com.slack.chatgpt.service;


public interface SlackService {

    void sendChatGPTMessageToChannel(String channelId, String question);

}
