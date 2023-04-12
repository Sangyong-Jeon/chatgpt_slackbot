package com.slack.chatgpt.service;

import com.slack.chatgpt.dto.chatgpt.ChatGPTResponse;

public interface ChatGPTService {
    ChatGPTResponse getChatGPTResponse(String prompt);
}
