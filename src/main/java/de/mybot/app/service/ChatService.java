package de.mybot.app.service;

import java.util.ArrayList;
import de.mybot.app.data.Product;
import de.mybot.app.data.Ticket;
import de.mybot.app.utils.UIEngine;

public class ChatService {
    private final ProductService productService = new ProductService();
    private final GeneralService generalService = new GeneralService();
    private final TicketService ticketService = new TicketService();
    private Ticket ticket;
    private Product selectedProduct;

    public void startChat() {
        ticket = Ticket.getInstance();

        UIEngine.clear();
        System.out.println("Willkommen zum Support-Chatbot JAVANATHAN!");
        UIEngine.waitForInput();

        runCustomerID();
        runProductChoice();
        runProblemChoice();

        runSpareparts();
        runProblemStatus();
        runFeedback();

        ticketService.createTicket(ticket);
    }

    private void runProductChoice() {
        UIEngine.clear();

        System.out.println("Um welches Produkt handelt es sich?");
        UIEngine productMenu = new UIEngine("Produkte");

        ArrayList<String> productOptions = new ArrayList<>();
        for (Product product : productService.getProducts()) {
            productOptions.add(product.getName());
        }

        productMenu.drawMenu(productOptions);
        int productChoice = UIEngine.getMenuInput(productOptions.size());

        selectedProduct = productService.getProductByChoice(productChoice);
        ticket.setProduct(selectedProduct.getName());
    }

    private void runProblemChoice() {
        UIEngine.clear();

        System.out.println("Um welche Art von Problem handelt es sich?");
        UIEngine problemMenu = new UIEngine("Problemart");

        ArrayList<String> problemOptions = new ArrayList<>();
        problemOptions.add("Allgemein");
        problemOptions.add("Produktspezifisch");

        problemMenu.drawMenu(problemOptions);
        int problemChoice = UIEngine.getMenuInput(problemOptions.size());

        if (problemChoice == 1) {
            generalService.run();
        } else if (problemChoice == 2) {
            productService.run(selectedProduct);
        }
    }

    private void runCustomerID() {
        UIEngine.clear();
        System.out.println("Geben Sie bitte ihre Kundennummer an");
        String customerID = UIEngine.fetchUserInput(true);
        ticket.setCostumerID(customerID);
    }

    private void runSpareparts() {
        UIEngine.clear();
        if (UIEngine.getUserResponse("Benötigen sie Ersatzteile für ihr Produkt?")) {
            UIEngine sparepartsMenu = new UIEngine("Ersatzteile für " + selectedProduct.getName());
            sparepartsMenu.drawMenu(selectedProduct.getSpareparts());
            int sparepartsChoice = UIEngine.getMenuInput(selectedProduct.getSpareparts().size());

            System.out.println("Ihre Ersatzteilanfrage wurde aufgenommen. " +
                    "Bitte kontaktieren Sie den Service Mitarbeiter unter folgender Telefonnummer: 080042069");

            ticket.setSparepartsNeeded(true);
            ticket.setSparepart(selectedProduct.getSpareparts().get(sparepartsChoice - 1));
        } else {
            ticket.setSparepartsNeeded(false);
        }

    }

    private void runProblemStatus() {
        UIEngine.clear();
        if (UIEngine.getUserResponse("Konnten wir Ihr Problem lösen?")) {
            System.out.println("Das freut uns sehr! " +
                    "Bitte nehmen Sie sich Zeit um Feedback zu geben.");
            ticket.setTicketStatus("resolved");
        } else {
            System.out.println("Das tut uns leid." +
                    " Bitte kontaktieren Sie den Service Mitarbeiter unter folgender Telefonnummer: 0800042069");
            ticket.setTicketStatus("unresolved");
        }
        UIEngine.waitForInput();
    }

    private void runFeedback() {
        UIEngine.clear();
        System.out.println("Wie würden sie die Erfahrung mit dem Chatbot bewerten? (1 bis 5)");
        int feedback = UIEngine.getMenuInput(5);
        ticket.setFeedback(feedback);

        System.out.println("Danke für Ihr Feedback! " +
                "Einen schönen Tag wünsche wir von der Bugland Company.");
    }
}

