package com.slack.chatgpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ChatgptSlackbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatgptSlackbotApplication.class, args);
    }

}
