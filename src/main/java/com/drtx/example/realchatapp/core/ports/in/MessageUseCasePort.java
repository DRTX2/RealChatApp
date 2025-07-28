package com.drtx.example.realchatapp.core.ports.in;

import com.drtx.example.realchatapp.core.models.WebSocketMessage;

public interface MessageUseCasePort {
    void processIncomingMessage(WebSocketMessage message);
}
