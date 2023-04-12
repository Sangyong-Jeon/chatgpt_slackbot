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
public class ChatGPTResponse {
    private String id;
    private String object;
    private int created;
    private List<Choice> choices;
    private Usage usage;
}
