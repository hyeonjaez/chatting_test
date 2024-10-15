package com.example.demo.service;

import com.example.demo.dto.ChatMessageRegisterRequest;
import com.example.demo.model.ChatMessage;
import com.example.demo.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;


    @Transactional(readOnly = true)
    public List<ChatMessage> findAllChatMessageByRoom(String chatRoomId) {
        return chatMessageRepository.findByChatRoomIdOrderByCreatedAt(chatRoomId);
    }

    public ChatMessage saveChatMessage(ChatMessageRegisterRequest chatMessageRegisterRequest) {
        ChatMessage chatMessage = new ChatMessage(
                chatMessageRegisterRequest.getChatRoomId(),
                chatMessageRegisterRequest.getMessageType(),
                chatMessageRegisterRequest.getContent(),
                chatMessageRegisterRequest.getUserId()
        );

        return chatMessageRepository.save(chatMessage);
    }
}
