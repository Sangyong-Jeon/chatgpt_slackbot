package com.slack.chatgpt.dto.chatgpt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGPTRequest {

    private String model;
    private List<Message> messages;
    private Integer max_tokens;

}
