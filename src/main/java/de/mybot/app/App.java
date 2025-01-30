package de.mybot.app;

import de.mybot.app.service.ChatService;

public class App {
    public static void main(String[] args) {
        ChatService chatService = new ChatService();
        chatService.startChat();
        /* TODO: Bug testen, Chatanweisungen überarbeiten/überprüfen, 
               Vergleich mit Mitbewerben(IKEA-Bot,H&M Chatbot), 
               Manual/Aktivitätsdiagramm/USE-Case Diagramm besprechen, Fachgespräch planen */
        /* Aufgabenverteilung: Esli:  
                               Gerrit: Bug fixen, Programm überprüfen/verbessern
                               Jonathan: Bug fixen */
        /* Fachgespräch: 1. Manual 2. Aktivitätsdiagramm, 3. USE-Case Diagramm, 
        4. Programm zeigen  
            1. Hauptablauf   
            2. UIEngine -> gefolgt von PseudoCode
        5. Ticket zeigen
            2.
            
         */
    }
}
