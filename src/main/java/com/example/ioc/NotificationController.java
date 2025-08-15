package com.example.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class NotificationController {
    @Autowired
    NotificationService nf;

    @PostMapping("/notify/all")
    private void notifyAllChannels(@RequestBody Map<String, String> req) {
        nf.sendToAllChannels(req.get("recipient"), req.get("message"));
    }

    @PostMapping("/notify/{channel}")
    private void notifySpecifiedChannel(@RequestBody Map<String, String> req) {
        nf.sendToChannel(req.get("channel"), req.get("recipient"), req.get("message"));
    }

    @GetMapping("channels")
    private String getAllChannels() {
        List<String> channelNames = nf.getChannels();
        StringBuilder sb = new StringBuilder();
        for (String channel : channelNames) {
            sb.append("Channel: ").append(channel).append("\n");
        }
        return sb.toString();
    }
}
