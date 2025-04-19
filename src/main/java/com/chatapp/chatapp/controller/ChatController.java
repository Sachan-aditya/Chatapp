package com.chatapp.chatapp.controller;

import com.chatapp.chatapp.dto.ChatMessageDTO;
import com.chatapp.chatapp.entities.ChatMessage;
import com.chatapp.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public ChatMessage sendMessage(@RequestBody ChatMessageDTO messageDTO) {
        return chatService.saveMessage(messageDTO);
    }

    @MessageMapping("/send-message")
    @SendTo("/topic/messages")
    public ChatMessage sendViaWebSocket(ChatMessageDTO messageDTO) {
        return chatService.saveMessage(messageDTO);
    }
}
