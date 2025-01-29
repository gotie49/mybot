package de.mybot.app;

import de.mybot.app.service.ChatService;

public class App {
    public static void main(String[] args) {
        ChatService chatService = new ChatService();
        chatService.startChat();
        /* TODO: Bug testen, Chatanweisungen überarbeiten/überprüfen, 
               Pseudo Code, Vergleich mit Mitbewerben(IKEA-Bot,H&M Chatbot), 
               Manual/Aktivitätsdiagramm/USE-Case Diagramm besprechen, Fachgespräch planen */
        /* Aufgabenverteilung: Esli:  Pseudocode
                               Gerrit: Bug fixen, Programm überprüfen/verbessern
                               Jonathan: Bug fixen */
        /* Fachgespräch (nur erste Idee): Vorstellen des Aktivitätsdiagramm, USE-Case Diagramm, 
                                Zeigen des Programms (-> gefolgt von Zeigen der Tickets), Integrationsmöglichkeiten,
                                Zeigen des Codes (-> gefolgt von Zeigen der Unit-Tests), Pseudocode, Vergleich mit Mitbewerbern */
    }
}
