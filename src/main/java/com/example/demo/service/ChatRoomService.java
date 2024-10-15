package com.example.demo.service;

import com.example.demo.dto.ChatRoomRegisterRequest;
import com.example.demo.model.ChatRoom;
import com.example.demo.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;


    public ChatRoom createChatRoom(ChatRoomRegisterRequest createChatRoomRequest) { //Todo response dto 로 필요한 것만 반환
        ChatRoom chatRoom = new ChatRoom(createChatRoomRequest.getTitle(), createChatRoomRequest.getUserId());

        return chatRoomRepository.save(chatRoom);
    }

    @Transactional(readOnly = true)
    public List<ChatRoom> getAllChatRoomsByUserId(String userId) { //Todo response dto 로 필요한 것만 반환
        return chatRoomRepository.findByParticipantsContains(userId);
    }

    public void addParticipant(String roomId, String userId) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId).orElseThrow(); //TODO throw 처리 해야함
        chatRoom.addParticipant(userId);
        chatRoomRepository.save(chatRoom);
    }

    public void removeParticipant(String roomId, String userId) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId).orElseThrow(); //TODO throw 처리 해야함
        chatRoom.removeParticipant(userId);
        chatRoomRepository.save(chatRoom);
    }
}
