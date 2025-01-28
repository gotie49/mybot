package de.mybot.app;

import de.mybot.app.service.ChatService;

public class App {
    public static void main(String[] args) {
        ChatService chatService = new ChatService();
        chatService.startChat();

        /* TODO: mvn exec plugin, separate logic from chatservice into individual classes, write hilfsanleitung, write feedback, ticket logic, ticket saves*/
    }
}
