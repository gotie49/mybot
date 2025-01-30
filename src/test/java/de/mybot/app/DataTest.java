package de.mybot.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import de.mybot.app.data.Issue;
import de.mybot.app.data.Product;
import de.mybot.app.data.Ticket;
import de.mybot.app.service.ProductService;

public class DataTest {
    private final ProductService productService = new ProductService();

    @Test
    void testIssueData() {
        assertEquals(productService.getProducts().get(1).getProductIssues().get(1).getDescription(), "Absturz bei Hindernissen");
        assertEquals(productService.getProducts().get(1).getProductIssues().get(1).getId(), "1");
    }

    @Test
    void testProduktData() {
        ArrayList<Product> products = productService.getProducts();

        ArrayList<Issue> testIssue = new ArrayList<>();
        testIssue.add(new Issue(1, "Hallo", "Gerrit ist doof"));
        ArrayList<String> testArray = new ArrayList<>();
        testArray.add("Räder");
        Product product = new Product(1, "HAHA", testIssue, testArray);

        assertEquals(products.get(2).getId(), 2);
        assertEquals(products.get(2).getName(), "Windowfly");
        assertEquals(product.getProductIssues(), testIssue);
        assertEquals(product.getSpareparts(), testArray);
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
