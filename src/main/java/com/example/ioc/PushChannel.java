package com.example.ioc;

import org.springframework.stereotype.Component;

@Component("push")
public class PushChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sent push to " + recipient + " with message: " + message);
    }

    @Override
    public String getChannelName() {
        return "Push channel";
    }
}
