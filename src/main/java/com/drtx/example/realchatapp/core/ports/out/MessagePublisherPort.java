package com.drtx.example.realchatapp.core.ports.out;

import com.drtx.example.realchatapp.core.models.WebSocketMessage;

public interface MessagePublisherPort {
    void publish(WebSocketMessage message);
}
