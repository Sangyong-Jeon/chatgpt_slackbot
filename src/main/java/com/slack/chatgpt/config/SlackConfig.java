package com.slack.chatgpt.config;

import com.slack.api.app_backend.slash_commands.payload.SlashCommandPayload;
import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import com.slack.chatgpt.service.SlackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SlackConfig {

    @Value("${slack.token}")
    private String token;
    @Value("${slack.signingSecret}")
    private String signingSecret;

    private final SlackService slackService;

    private static final String WAIT_MESSAGE = ":robot_face: :speech_balloon: 잠시만 기다려주세요. ChatGPT가 답변을 작성하고 있습니다.";

    @Bean
    public AppConfig loadSingleWorkspaceAppConfig() {
        return AppConfig.builder()
                .singleTeamBotToken(token)
                .signingSecret(signingSecret)
                .build();
    }

    @Bean
    public App initSlackApp(AppConfig config) {
        App app = new App(config);

        app.command("/gpt", (req, ctx) -> {
            SlashCommandPayload payload = req.getPayload();
            String userId = "<@" + payload.getUserId() + ">";
            String question = payload.getText();
            ctx.respond(r -> r.responseType("in_channel").text(":question: " + userId + "님의 질문 : " + question));
            ctx.respond(r -> r.responseType("in_channel").text(WAIT_MESSAGE));
            slackService.sendChatGPTMessageToChannel(payload.getChannelId(), question);
            return ctx.ack();
        });

        return app;
    }
}
