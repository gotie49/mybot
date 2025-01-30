package de.mybot.app.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import de.mybot.app.data.Ticket;

public class TicketService {
    public void createTicket(Ticket ticket) {
        Map<String, Object> ticketMap = new LinkedHashMap<>(); //ensures order within the ticket
        ticketMap.put("costumer_id", ticket.getCostumerID());
        ticketMap.put("ticket_status", ticket.getTicketStatus());
        ticketMap.put("product", ticket.getProduct());
        ticketMap.put("problem_type", ticket.getProblemType());
        ticketMap.put("issue", ticket.getIssue());
        ticketMap.put("sparepartsNeeded", ticket.getSparepartsNeeded());
        if (ticket.getSparepartsNeeded()) {
            ticketMap.put("sparepart", ticket.getSparepart());
        }
        ticketMap.put("feedback", ticket.getFeedback());
        JSONObject ticketJson = new JSONObject(ticketMap);
        saveTicketToFile(ticketJson, ticket.getCostumerID()); //how to ensure no duplicates?
    }

    private void saveTicketToFile(JSONObject ticket, String id) {
        String folderName = "tickets";
        Path folderPath = Paths.get(folderName);
        try {
            Files.createDirectories(folderPath);
        } catch (IOException e) {
            System.err.println("Ticket Ordner konnte nicht erstellt werden.");
            e.printStackTrace();
            return;
        }

        Path filePath = folderPath.resolve("ticket_" + id + ".json");
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
            writer.write(ticket.toString(4));
            System.out.println("Ticket gespeichert.");
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern des Tickets.");
            e.printStackTrace();
        }
    }
}
