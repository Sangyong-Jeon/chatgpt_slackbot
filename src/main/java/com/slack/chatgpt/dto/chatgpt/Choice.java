package com.slack.chatgpt.dto.chatgpt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
    private int index;
    private Message message;
    private String finish_reason;
}
