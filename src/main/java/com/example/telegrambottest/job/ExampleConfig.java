package com.example.telegrambottest.job;

import com.example.telegrambottest.feign.TelegramAPIClient;
import com.example.telegrambottest.task.ExampleTasklet;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ExampleConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final TelegramAPIClient telegramAPIClient;


    @Bean
    public Job tutorialJob() {
        return jobBuilderFactory.get("exampleJob")
                .start(tutorialStep())  // Step 설정
                .build();
    }

    @Bean
    public Step tutorialStep() {
        return stepBuilderFactory.get("exampleStep")
                .tasklet(new ExampleTasklet(telegramAPIClient))
                .build();
    }
}