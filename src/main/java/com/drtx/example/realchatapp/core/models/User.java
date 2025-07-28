package com.drtx.example.realchatapp.core.models;

import java.time.Instant;
import java.util.List;

public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String description;
    private OnlineStatus onlineStatus;
    private Instant lastSeen;
    private Instant createdAt;
    private List<Message> messages;

    public User(String username, String password, String email, String avatar, String description, OnlineStatus onlineStatus, Instant lastSeen, Instant createdAt, List<Message> messages) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.description = description;
        this.onlineStatus = onlineStatus;
        this.lastSeen = lastSeen;
        this.createdAt = createdAt;
        this.messages=messages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OnlineStatus getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(OnlineStatus onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Instant getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Instant lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
