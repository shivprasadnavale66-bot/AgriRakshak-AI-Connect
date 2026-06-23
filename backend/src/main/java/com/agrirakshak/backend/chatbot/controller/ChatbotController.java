package com.agrirakshak.backend.chatbot.controller;

import com.agrirakshak.backend.chatbot.dto.ChatRequest;
import com.agrirakshak.backend.chatbot.dto.ChatResponse;
import com.agrirakshak.backend.chatbot.service.ChatbotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatbot")
@RequiredArgsConstructor
public class ChatbotController {

    private final ChatbotService chatbotService;

    @PostMapping("/ask")
    public ChatResponse ask(@RequestBody ChatRequest request) {
        return chatbotService.getReply(request.getMessage());
    }
}