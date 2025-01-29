package de.mybot.app;

import de.mybot.app.service.ChatService;

public class App {
    public static void main(String[] args) {
        ChatService chatService = new ChatService();
        chatService.startChat();
        /* TODO: clear() anpassen (Eingabe erwarten), Bug testen, Chatanweisungen überarbeiten/überprüfen, Zurück Option , 
            Unnütze Tests schreiben, Pseudo Code, Manual, */
        /* Aufgabenverteilung: Esli:  Pseudocode (drawMenu())
                               Gerrit: Manual, Bug fixen, Programm überprüfen/verbessern
                               Jonathan: Tests Schreiben, Bug fixen*/
    }
}
