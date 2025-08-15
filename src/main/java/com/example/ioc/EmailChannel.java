package com.example.ioc;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailChannel implements NotificationChannel{

    @Override
    public void send(String recipient, String message) {
        System.out.println("Sent email to " + recipient + " with message: " + message);
    }

    @Override
    public String getChannelName() {
        return "Email channel";
    }
}
