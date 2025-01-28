package de.mybot.app.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.mybot.app.data.Ticket;
import org.json.JSONObject;

public class TicketService {
    public void createTicket(Ticket ticket) {
        JSONObject ticketfinal = new JSONObject();
        ticketfinal.put("product", ticket.getProduct());
        ticketfinal.put("costumerID", ticket.getCostumerID());
        ticketfinal.put("status", ticket.getStatus());
        ticketfinal.put("spareparts",ticket.getSpareparts());
        saveTicketToFile(ticketfinal,ticket.getCostumerID());
    }

    private void saveTicketToFile(JSONObject ticket,String id) {
        String folderName = "tickets";
        File folder = new File(folderName);
        folder.mkdir();
        try (FileWriter file = new FileWriter("./tickets/ticket_"+id+".json", true)) {
            file.write(ticket.toString(4) + System.lineSeparator());
            System.out.println("Ticket gespeichert.");
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern des Tickets.");
        }
    }
}
