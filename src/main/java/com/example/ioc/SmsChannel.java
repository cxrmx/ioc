package com.example.ioc;

import org.springframework.stereotype.Component;

@Component("sms")
public class SmsChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sent sms to " + recipient + " with message: " + message);
    }

    @Override
    public String getChannelName() {
        return "Sms channel";
    }
}
