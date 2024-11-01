package com.devsuperior.springbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@StepScope //falamos que ela está no escopo do Step
public class PrintHelloTasklet implements Tasklet {

    @Value("${name}")
    private String name;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        //antes
        //System.out.println("Hello, world!");

        //depois
        System.out.println("Olá " + name);
        return RepeatStatus.FINISHED;
    }
}
