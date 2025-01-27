package de.mybot.app.service;

import java.util.Scanner;
import de.mybot.app.data.Issue;
import de.mybot.app.data.Product;

public class ChatService {
    private final ProductService productService = new ProductService();
    private final GeneralService generalService = new GeneralService();
    //private final TicketService ticketService = new TicketService();

    private int customerId = 0;

    public void startChat() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen zum Support-Chatbot JAVANATHAN!");
        //TODO: Kundennummer
        System.out.println("Geben Sie ihre Kundennummer an oder ich töte Sie");
        customerId = scanner.nextInt();

        System.out.println("Um welches Produkt handelt es sicht?");

        for (Product product : productService.getProducts()) {
            System.out.println(product.getId() + ". " + product.getName());
        }
        int productChoice = scanner.nextInt();
        Product selectedProduct = productService.getProductByChoice(productChoice);

        System.out.println("Um welche Art von Problem handelt es sicht?");
        System.out.println("1. allgemein");
        System.out.println("2. produktspezifisch");

        int problemChoice = scanner.nextInt();
        if (problemChoice == 1) {
            generalService.displayGeneralIssues();

            int issueChoice = scanner.nextInt();
            Issue generalIssue = generalService.getIssueByChoice(issueChoice);

            generalService.provideHelp(generalIssue);
        } else if (problemChoice == 2) {
            productService.displayProductIssues(selectedProduct);

            int issueChoice = scanner.nextInt();
            Issue productIssue = productService.getIssueByChoice(selectedProduct, issueChoice);

            productService.provideHelp(selectedProduct, productIssue);
        } else {
            System.out.println("Ungültige Eingabe");
        }
        //allgemeine Dinge die für alles gelten, hier Feedback
    
    }
}

