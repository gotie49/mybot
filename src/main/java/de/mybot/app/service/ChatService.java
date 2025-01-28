package de.mybot.app.service;

import java.util.Scanner;
import de.mybot.app.data.Issue;
import de.mybot.app.data.Product;
import de.mybot.app.data.Ticket;

public class ChatService {
    private final ProductService productService = new ProductService();
    private final GeneralService generalService = new GeneralService();
    //private final TicketService ticketService = new TicketService();

    private int customerId = 0;

    public void startChat() {
        final Scanner scanner = new Scanner(System.in);
        Ticket ticket = new Ticket();

        System.out.println("Willkommen zum Support-Chatbot JAVANATHAN!");
        //TODO: Kundennummer, move this to end of program
        System.out.println("Geben Sie ihre Kundennummer an oder ich töte Sie");
        customerId = scanner.nextInt();
        ticket.setCostumerID(Integer.toString(customerId));

        System.out.println("Um welches Produkt handelt es sicht?");

        for (Product product : productService.getProducts()) {
            System.out.println(product.getId() + ". " + product.getName());
        }
        int productChoice = scanner.nextInt();
        Product selectedProduct = productService.getProductByChoice(productChoice);
        ticket.setProduct(selectedProduct.getName());

        System.out.println("Um welche Art von Problem handelt es sicht?");
        System.out.println("1. allgemein");
        System.out.println("2. produktspezifisch");

        int problemChoice = scanner.nextInt();

        if (problemChoice == 1) {
            generalService.run();
            ticket.setIssueType("Allgemein");
            /*generalService.displayGeneralIssues();

            int issueChoice = scanner.nextInt();
            Issue generalIssue = generalService.getIssueByChoice(issueChoice);

            generalService.provideHelp(generalIssue); */
        } else if (problemChoice == 2) {
            ticket.setIssueType("produktspezifisch");
            productService.displayProductIssues(selectedProduct);

            int issueChoice = scanner.nextInt();
            Issue productIssue = productService.getIssueByChoice(selectedProduct, issueChoice);

            productService.provideHelp(selectedProduct, productIssue);
        } else {
            System.out.println("Ungültige Eingabe");
        }
        TicketService ticketService = new TicketService();
        ticketService.createTicket(ticket);
        //allgemeine Dinge die für alles gelten, hier Feedback



    }
}

