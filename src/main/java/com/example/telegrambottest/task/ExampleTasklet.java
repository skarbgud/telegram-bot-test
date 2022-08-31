package com.example.telegrambottest.task;

import com.example.telegrambottest.feign.TelegramAPIClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

@Slf4j
public class ExampleTasklet implements Tasklet {

    private final TelegramAPIClient telegramAPIClient;

    public ExampleTasklet(TelegramAPIClient telegramAPIClient) {
        this.telegramAPIClient = telegramAPIClient;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("send message start");
        telegramAPIClient.sendMessage("5737721084:AAFgBAJKfxlu7gS9Cw1rrRVLrNen2nxbqb8", "test send message!", "5382455730");
        return RepeatStatus.FINISHED;
    }
}
