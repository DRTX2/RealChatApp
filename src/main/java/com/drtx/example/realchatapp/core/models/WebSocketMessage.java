package com.drtx.example.realchatapp.core.models;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class WebSocketMessage {
    private final String id;
    private final String content;
    private final MessageType type;
    private final LocalDateTime timestamp;
    private final String senderId;

    public WebSocketMessage(Builder builder) {
        this.id = builder.id;
        this.content = builder.content;
        this.type = builder.type;
        this.timestamp = builder.timestamp;
        this.senderId = builder.senderId;
    }

    public static class Builder {
        private String id;
        private String content;
        private MessageType type;
        private LocalDateTime timestamp;
        private String senderId;

        public Builder() {
            this.id = UUID.randomUUID().toString();
            this.timestamp = LocalDateTime.now();
        }

        public Builder id(String id){
            this.id=id;
            return this;
        }

        public Builder content(String content){
            this.content=content;
            return this;
        }

        public Builder type(MessageType type){
            this.type=type;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp){
            this.timestamp=timestamp;
            return this;
        }
        public Builder senderId(String senderId){
            this.senderId=senderId;
            return this;
        }

        public Builder senderId(String senderId, String username){
            this.senderId=senderId;
            return this;
        }

        public WebSocketMessage build(){
            return new WebSocketMessage(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebSocketMessage that = (WebSocketMessage) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(content, that.content) &&
                type == that.type &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(senderId, that.senderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, type, timestamp, senderId);
    }

    @Override
    public String toString() {
        return "WebSocketMessage{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", timestamp=" + timestamp +
                ", senderId='" + senderId + '\'' +
                '}';
    }
}
