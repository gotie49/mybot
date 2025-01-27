package de.mybot.app.service;

import java.util.Scanner;

public class ChatService {
    private final ProductService productService = new ProductService();
    private final GeneralService generalService = new GeneralService();
    //private final TicketService ticketService = new TicketService();

    public void startChat() {
        System.out.println("Willkommen zum Support-Chatbot JAVANATHAN!");
        System.out.println("Bitte wählen Sie ein Produkt aus:");
        System.out.println("1. Cleanbug\n2. Windowfly\n3. Gardenbeetle");

        Scanner scanner = new Scanner(System.in);
        int productChoice = scanner.nextInt();

        String product = productService.getProductNameByChoice(productChoice);

        if (product != null) {
            System.out.println("Welche Art von Problem haben Sie?");
            System.out.println("1. produktspezifisch\n2. allgemein");
            int problemChoice = scanner.nextInt();
            String problemKind = getProblemByChoice(problemChoice);

            if (problemKind == "general") {
                generalService.displayGeneralIssues();
                int issueChoice = scanner.nextInt();

                String issue = generalService.getIssueByChoice(issueChoice);
                if (issue != null) {
                    System.out.println("Problem: " + issue);

                }
            } else if (problemKind == "specific") {
                System.out.println("Bitte wählen Sie das Problem aus:");
                productService.displayProductIssues(product);
                int issueChoice = scanner.nextInt();

                String issue = productService.getIssueByChoice(product, issueChoice);
                if (issue != null) {
                    System.out.println("Problem: " + issue);
                    productService.provideHelp(product, issue);

                    System.out.println("Problem gelöst? (JA/NEIN)");
                    String solved = scanner.next().toLowerCase();

                    //ticketService.createTicket(product, issue, solved.equals("nein"));
                } else {
                    System.out.println("Ungültige Eingabe. Starten Sie neu.");
                }
            }
        } else {
            System.out.println("Ungültige Eingabe. Starten Sie neu.");
        }
    }

    private String getProblemByChoice(int choice) {
        return switch (choice) {
            case 1 -> "specific";
            case 2 -> "general";
            default -> null;
        };

    }
}

