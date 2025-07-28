package com.drtx.example.realchatapp.infrastructure.websocket;

import jakarta.websocket.Session;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ChatWebSocketHandler extends TextWebSocketHandler {
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //simple, lo que recibe reenvia a todos
        for (WebSocketSession s: session.getOpenSessions()) {
            if (s.isOpen()) {
                s.sendMessage(message);
            }
        }
    }
}
