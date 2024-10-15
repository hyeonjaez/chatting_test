package com.example.demo.model;

import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Document(collection = "chatRooms")
public class ChatRoom {
    @Id
    private final String id;
    private final String title;
    private final Set<String> participants; //TODO 유저로 바꿔야 할듯? 아니면 userdto  만들어서  id, name, 프로필 사진 있게

    public ChatRoom(String title, String userId) {
        this.id = new StringBuilder().append(UUID.randomUUID()).append("|").append(userId).toString();
        this.title = title;
        participants = new HashSet<>();
        participants.add(userId);
    }

    public void addParticipant(String userId) {
        participants.add(userId);
    }

    public void removeParticipant(String userId) {
        participants.remove(userId);
    }
}
