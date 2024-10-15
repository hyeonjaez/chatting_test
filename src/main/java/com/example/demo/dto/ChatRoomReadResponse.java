package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatRoomReadResponse {
    private String title;
    private Long personCount;
    private String lastMessage;
}
