package com.touristicbot.natalliavasilyeva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;


@SpringBootApplication(scanBasePackages = "com.touristicbot.natalliavasilyeva")
public class TouristicBotApplication {

    public static void main(String... args) {
        ApiContextInitializer.init();
        SpringApplication.run(TouristicBotApplication.class, args);
    }
}
