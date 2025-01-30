package de.mybot.app;

import de.mybot.app.data.Issue;
import de.mybot.app.data.Product;
import de.mybot.app.data.Ticket;
import de.mybot.app.service.GeneralService;
import de.mybot.app.service.ProductService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DataTest {
    private final GeneralService generalService = new GeneralService();
    private final ProductService productService = new ProductService();

    @Test
    void testIssueData() {
        Issue issue = new Issue(1,"Hallo","Gerrit ist doof");
        assertEquals(issue.getId(), 1);
        assertEquals(issue.getDescription(),"Hallo");
    }

    @Test
    void testProduktData() {
        ArrayList<Issue> testIssue = new ArrayList<>();
        testIssue.add(new Issue(1,"Hallo","Gerrit ist doof"));
        ArrayList<String> testArray = new ArrayList<>();
        testArray.add("Räder");
        Product product = new Product(1,"HAHA" ,testIssue ,testArray);

        assertEquals(product.getId(),1);
        assertEquals(product.getName(),"HAHA");
        assertEquals(product.getProductIssues(),testIssue);
        assertEquals(product.getSpareparts(),testArray);
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

        assertEquals(ticket.getCostumerID(),"111");
        assertEquals(ticket.getTicketStatus(),"resolved");
        assertEquals(ticket.getFeedback(),5);
        assertEquals(ticket.getSparepart(),"Kopf");
        assertEquals(ticket.getSparepartsNeeded(),true);
        assertEquals(ticket.getProblemType(),"general");
        assertEquals(ticket.getProduct(),"product");
        assertEquals(ticket.getIssue(),"1");
    }

}
