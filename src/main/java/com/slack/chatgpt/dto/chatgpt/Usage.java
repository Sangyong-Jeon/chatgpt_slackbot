package com.slack.chatgpt.dto.chatgpt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usage {
    public int prompt_tokens;
    public int completion_tokens;
    public int total_tokens;
}
