package com.drtx.example.realchatapp.adapters.out.persistence.user;

import com.drtx.example.realchatapp.adapters.out.persistence.message.MessageEntity;
import com.drtx.example.realchatapp.core.models.Message;
import com.drtx.example.realchatapp.core.models.OnlineStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "app_users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String avatar="";

    private String description="";

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OnlineStatus onlineStatus;

    private Instant lastSeen;

    private Instant createdAt;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MessageEntity> sendtMessages;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MessageEntity> receivedMessages;
}
