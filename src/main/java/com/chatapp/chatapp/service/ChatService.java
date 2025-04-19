package com.chatapp.chatapp.service;

import com.chatapp.chatapp.dto.ChatMessageDTO;
import com.chatapp.chatapp.entities.ChatMessage;
import com.chatapp.chatapp.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.sql.Timestamp;

@Service
public class ChatService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public ChatMessage saveMessage(ChatMessageDTO messageDTO) {
        ChatMessage message = new ChatMessage();
        message.setContent(messageDTO.getContent());
        message.setSender(messageDTO.getSender());
        message.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));

        return chatMessageRepository.save(message);
    }
}
