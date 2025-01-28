package de.mybot.app;

import de.mybot.app.service.ChatService;

public class App {
    public static void main(String[] args) {
        ChatService chatService = new ChatService();
        chatService.startChat();

        //TODO: möglicherweise Issues als Eigenschaft der Produkt Klasse, so dass List<Products> products bereits die 
        // Issues beinhaltet,  
    }
}
