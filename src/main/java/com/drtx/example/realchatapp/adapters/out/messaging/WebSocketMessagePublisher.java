package com.drtx.example.realchatapp.adapters.out.messaging;

import com.drtx.example.realchatapp.core.models.WebSocketMessage;
import com.drtx.example.realchatapp.core.ports.out.MessagePublisherPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class WebSocketMessagePublisher implements MessagePublisherPort {
    private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();

    public void register(WebSocketSession session) {
        sessions.add(session);
    }

    public void unregister(WebSocketSession session) {
        sessions.remove(session);
    }

    @Override
    public void publish(WebSocketMessage message) {
        String json ;
        try{
            json = new ObjectMapper().writeValueAsString(message);
        }catch (JsonProcessingException e ){
            return;
        }

        for(WebSocketSession session:sessions){
            try{
                if(session.isOpen()) session.sendMessage(new TextMessage(json));
            }catch(IOException ignored){
                System.out.println("An error ocurred while sending message to session: " + session.getId());
            }
        }
    }
}
