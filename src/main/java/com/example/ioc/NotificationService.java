package com.example.ioc;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NotificationService {
    private final Map<String, NotificationChannel> channels;

//    private final NotificationChannel smsChannel;
//
//    private final NotificationChannel emailChannel;
//
//    private final NotificationChannel pushChannel;

    public NotificationService(Map<String, NotificationChannel> channels) {
        this.channels = channels;
    }

    public void sendToAllChannels(String recipient, String message) {
        for (Map.Entry<String, NotificationChannel> ch : channels.entrySet()) {
            if (ch.getValue() != null)
                ch.getValue().send(recipient, message);
            else
                throw new IllegalArgumentException("Channel not found " + ch.getKey());
        }

//        smsChannel.send(recipient, message);
//        emailChannel.send(recipient, message);
//        pushChannel.send(recipient, message);
    }

    public void sendToChannel(String channelName, String recipient, String message) {
        if (channels.get(channelName) != null)
            channels.get(channelName).send(recipient, message);
        else
            throw new IllegalArgumentException("Channel " + channelName + " is null");
    }

    public List<String> getChannels() {
        return new ArrayList<>(this.channels.keySet());
    }
}
