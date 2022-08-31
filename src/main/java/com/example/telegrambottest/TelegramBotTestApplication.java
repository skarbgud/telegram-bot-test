package com.example.telegrambottest;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBatchProcessing
@EnableFeignClients
@EnableScheduling
public class TelegramBotTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotTestApplication.class, args);
    }

}
