package com.example.ioc;

public interface NotificationChannel {
    void send(String recipient, String message);
    String getChannelName();
}
