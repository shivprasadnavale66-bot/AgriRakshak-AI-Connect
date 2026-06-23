package com.agrirakshak.backend.chatbot.service;

import com.agrirakshak.backend.chatbot.dto.ChatResponse;
import com.agrirakshak.backend.config.GeminiConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChatbotServiceImpl implements ChatbotService {

    private final WebClient webClient;
    private final GeminiConfig geminiConfig;

    @Override
    public ChatResponse getReply(String message) {

        try {

            String url =
                    "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                            + geminiConfig.getApiKey();

            Map<String, Object> requestBody = Map.of(
                    "contents", new Object[]{
                            Map.of(
                                    "parts", new Object[]{
                                            Map.of("text", message)
                                    }
                            )
                    }
            );

            Map response = webClient.post()
                    .uri(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            if (response != null) {

                var candidates = (java.util.List<?>) response.get("candidates");

                if (candidates != null && !candidates.isEmpty()) {

                    Map<?, ?> candidate = (Map<?, ?>) candidates.get(0);
                    Map<?, ?> content = (Map<?, ?>) candidate.get("content");
                    var parts = (java.util.List<?>) content.get("parts");

                    if (parts != null && !parts.isEmpty()) {

                        Map<?, ?> part = (Map<?, ?>) parts.get(0);
                        String reply = (String) part.get("text");

                        return new ChatResponse(reply);
                    }
                }
            }

            return new ChatResponse("No response received from Gemini.");

        } catch (Exception e) {

            return new ChatResponse("Error: " + e.getMessage());
        }
    }
}