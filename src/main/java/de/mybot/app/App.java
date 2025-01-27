package de.mybot.app;

import de.mybot.app.service.ChatService;

public class App {
    public static void main(String[] args) {
        ChatService chatService = new ChatService();
        chatService.startChat();
    }
}
