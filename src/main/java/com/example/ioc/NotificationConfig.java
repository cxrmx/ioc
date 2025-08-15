package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class NotificationConfig {
    @Bean
    @Qualifier("telegram")
    public NotificationChannel telegram() {
        return new NotificationChannel() {
            @Override
            public void send(String recipient, String message) {
                System.out.println("Sent telegram to " + recipient + " with message: " + message);
            }

            @Override
            public String getChannelName() {
                return "Telegram channel";
            }
        };
    }
}
