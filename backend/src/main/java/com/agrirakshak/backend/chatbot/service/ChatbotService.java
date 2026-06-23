package com.agrirakshak.backend.chatbot.service;

import com.agrirakshak.backend.chatbot.dto.ChatResponse;

public interface ChatbotService {

    ChatResponse getReply(String message);

}