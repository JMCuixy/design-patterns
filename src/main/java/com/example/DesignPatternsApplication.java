package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@SpringBootApplication
public class DesignPatternsApplication implements AsyncConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsApplication.class, args);

    }

    @Override
    public Executor getAsyncExecutor() {
        return Executors.newCachedThreadPool();
    }
}
