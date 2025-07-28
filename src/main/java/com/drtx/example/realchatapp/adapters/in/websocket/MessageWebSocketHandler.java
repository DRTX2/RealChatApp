package com.drtx.example.realchatapp.adapters.in.websocket;

import com.drtx.example.realchatapp.core.models.WebSocketMessage;
import com.drtx.example.realchatapp.core.ports.in.MessageUseCasePort;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class MessageWebSocketHandler extends TextWebSocketHandler {
    private final MessageUseCasePort messageUseCase;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws IOException {
        try {
            WebSocketMessage message = new ObjectMapper().readValue(textMessage.getPayload(), WebSocketMessage.class);
            messageUseCase.processIncomingMessage(message);
        } catch (Exception e) {
            session.sendMessage(new TextMessage("{\"error\":\"Formato inválido\"}"));
        }
    }
}
