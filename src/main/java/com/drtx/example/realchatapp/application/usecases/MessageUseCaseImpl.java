package com.drtx.example.realchatapp.application.usecases;

import com.drtx.example.realchatapp.core.models.WebSocketMessage;
import com.drtx.example.realchatapp.core.ports.in.MessageUseCasePort;
import com.drtx.example.realchatapp.core.ports.out.MessagePublisherPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageUseCaseImpl implements MessageUseCasePort {
    private final MessagePublisherPort publisher;

    @Override
    public void processIncomingMessage(WebSocketMessage message) {
        publisher.publish(message);
    }

}
