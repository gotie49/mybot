package de.mybot.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import de.mybot.app.data.Product;
import de.mybot.app.data.Ticket;
import de.mybot.app.service.ProductService;

public class DataTest {
    private final ProductService productService = new ProductService();
    private final ArrayList<Product> products = productService.getProducts();

    @Test
    void testIssueData() {
        assertEquals(products.get(1).getProductIssues().get(1).getDescription(), "Gerät rutscht ab");
        assertEquals(products.get(1).getProductIssues().get(1).getId(), 2);
    }

    @Test
    void testProduktData() {
        assertEquals(products.get(2).getId(), 3);
        assertEquals(products.get(2).getName(), "Gardenbeetle");
        assertEquals(products.get(1).getProductIssues().get(1).getDescription(), "Gerät rutscht ab");
        assertEquals(products.get(2).getSpareparts().get(1), "Bürsten");
    }

    @Test
    void testTicketData() {
        Ticket ticket = Ticket.getInstance();
        ticket.setProduct("product");
        ticket.setCostumerID("111");
        ticket.setTicketStatus("resolved");
        ticket.setFeedback(5);
        ticket.setSparepart("Kopf");
        ticket.setSparepartsNeeded(true);
        ticket.setIssue("1");
        ticket.setProblemType("general");

        assertEquals(ticket.getCostumerID(), "111");
        assertEquals(ticket.getTicketStatus(), "resolved");
        assertEquals(ticket.getFeedback(), 5);
        assertEquals(ticket.getSparepart(), "Kopf");
        assertEquals(ticket.getSparepartsNeeded(), true);
        assertEquals(ticket.getProblemType(), "general");
        assertEquals(ticket.getProduct(), "product");
        assertEquals(ticket.getIssue(), "1");
    }

}
