package com.drtx.example.realchatapp.adapters.out.persistence.message;

import com.drtx.example.realchatapp.adapters.out.persistence.user.UserEntity;
import com.drtx.example.realchatapp.core.models.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "messages")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sender_id", nullable = false)
    UserEntity sender;

    @ManyToOne(optional = false)
    @JoinColumn(name = "receiver_id", nullable = false)
    UserEntity receiver;

    @Column(nullable = false)
    Instant createdAt;

    Instant updatedAt;

    @Column(nullable = false)
    boolean isRead=false;

    @Column(nullable = false)
    boolean isDeleted=false;

    @Column(nullable = false)
    boolean isEdited=false;

    @Column(nullable = false)
    boolean isPinned=false;
}
