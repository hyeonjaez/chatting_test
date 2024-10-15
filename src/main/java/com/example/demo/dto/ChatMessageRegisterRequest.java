package com.example.demo.dto;

import com.example.demo.model.MessageType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatMessageRegisterRequest {
    private String chatRoomId;
    private String content;
    private String userId;
    private MessageType messageType;
    private String replyMessageId;
}
