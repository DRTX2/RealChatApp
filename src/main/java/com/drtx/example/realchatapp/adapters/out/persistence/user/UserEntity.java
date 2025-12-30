package com.drtx.example.realchatapp.adapters.out.persistence.user;

import com.drtx.example.realchatapp.adapters.out.persistence.message.MessageEntity;
import com.drtx.example.realchatapp.core.models.OnlineStatus;
import com.drtx.example.realchatapp.core.models.Role;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.List;
import java.util.Set;

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
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Builder.Default
    private String avatar = "";

    @Builder.Default
    private String description = "";

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OnlineStatus onlineStatus;

    private Instant lastSeen;

    private Instant createdAt;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MessageEntity> sentMessages;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MessageEntity> receivedMessages;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<Role> roles;

    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
    }
}
