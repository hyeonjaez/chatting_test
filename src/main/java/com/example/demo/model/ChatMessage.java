package com.example.demo.model;


import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@Document(collection = "chatMessage")
public class ChatMessage {
    @Id
    private String id;
    private String chatRoomId;
    private MessageType messageType;
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;
    private String userId;
    private ChatMessage replyMessage;

    public ChatMessage(String chatRoomId, MessageType messageType, String content, String userId) {
        this.id = new StringBuilder().append(UUID.randomUUID()).append("|").append(chatRoomId).toString();
        this.chatRoomId = chatRoomId;
        this.messageType = messageType;
        this.content = content;
        this.userId = userId;
    }
}
