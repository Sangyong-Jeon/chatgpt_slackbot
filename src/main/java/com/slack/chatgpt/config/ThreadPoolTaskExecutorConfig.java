package com.slack.chatgpt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class ThreadPoolTaskExecutorConfig {

    @Bean("ThreadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10); // 기본 생성 개수
        executor.setQueueCapacity(50); // 스레드 전부 사용 시, 큐에 해당 숫자만큼 만들어서 대기
        executor.setMaxPoolSize(100); // 큐가 꽉차면 풀을 해당 개수까지 더 생성함
        executor.setThreadNamePrefix("CustomThread");
        return executor;
    }
}
