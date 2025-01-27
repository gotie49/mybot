package de.mybot.app.service;
/*
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public class TicketService {
    public void createTicket(String product, String issue, boolean unresolved) {
        JSONObject ticket = new JSONObject();
        ticket.put("product", product);
        ticket.put("issue", issue);
        ticket.put("status", unresolved ? "unresolved" : "resolved");
        saveTicketToFile(ticket);
    }

    private void saveTicketToFile(JSONObject ticket) {
        try (FileWriter file = new FileWriter("tickets.json", true)) {
            file.write(ticket.toString() + System.lineSeparator());
            System.out.println("Ticket gespeichert.");
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern des Tickets.");
        }
    }
}
*/