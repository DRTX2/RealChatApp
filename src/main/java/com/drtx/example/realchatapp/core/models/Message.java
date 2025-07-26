package com.drtx.example.realchatapp.core.models;

import java.time.Instant;

public class Message {
    String content;
    User sender;
    User receiver;
    Instant createdAt;
    Instant updatedAt;
    boolean isRead;
    boolean isDeleted;
    boolean isEdited;
    boolean isPinned;
//    boolean isPrivate;
}
