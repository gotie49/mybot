package de.mybot.app.service;

import java.util.ArrayList;
import java.util.List;
import de.mybot.app.data.Issue;
import de.mybot.app.data.Product;
import de.mybot.app.data.Ticket;
import de.mybot.app.utils.UIEngine;

public class ProductService {
    private final ArrayList<Product> products = new ArrayList<>();
    private Product selectedProduct;
    private Ticket ticket = Ticket.getInstance();

    public ProductService() {
        ArrayList<Issue> cleanbugIssues = new ArrayList<>();
        cleanbugIssues.add(new Issue(1, "Absturz bei Hindernissen", getCleanbugSolution(1)));
        cleanbugIssues.add(new Issue(2, "Gerät startet nicht", getCleanbugSolution(2)));
        cleanbugIssues.add(new Issue(3, "Reinigung nicht effektiv", getCleanbugSolution(3)));

        ArrayList<Issue> windowflyIssues = new ArrayList<>();
        windowflyIssues.add(new Issue(1, "Gerät bleibt am Fenster haftern", getWindowflySolution(1)));
        windowflyIssues.add(new Issue(2, "Gerät rutscht ab", getWindowflySolution(2)));
        windowflyIssues.add(new Issue(3, "Gerät startet nicht", getWindowflySolution(3)));

        ArrayList<Issue> gardenbeetleIssues = new ArrayList<>();
        gardenbeetleIssues.add(new Issue(1, "Gerät bleibt stecken", getGardenbeetleSolution(1)));
        gardenbeetleIssues.add(new Issue(2, "Gerät mäht nicht richtig", getGardenbeetleSolution(2)));
        gardenbeetleIssues.add(new Issue(3, "Gerät startet nicht", getGardenbeetleSolution(3)));

        ArrayList<String> cleanbugSpareparts = new ArrayList<>();
        cleanbugSpareparts.add("Getriebe");
        cleanbugSpareparts.add("Dichtung");
        cleanbugSpareparts.add("Akku");

        ArrayList<String> windowflySpareparts = new ArrayList<>();
        windowflySpareparts.add("Getriebe");
        windowflySpareparts.add("Dichtung");
        windowflySpareparts.add("Akku");

        ArrayList<String> gardenbeetleSpareparts = new ArrayList<>();
        gardenbeetleSpareparts.add("Getriebe");
        gardenbeetleSpareparts.add("Dichtung");
        gardenbeetleSpareparts.add("Akku");


        Product cleanbug = new Product(1, "Cleanbug", cleanbugIssues, cleanbugSpareparts);
        Product windowfly = new Product(2, "Windowfly", windowflyIssues, windowflySpareparts);
        Product gardenbeetle = new Product(3, "Gardenbeetle", gardenbeetleIssues, gardenbeetleSpareparts);

        products.add(cleanbug);
        products.add(windowfly);
        products.add(gardenbeetle);
    }

    public void run(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
        ticket.setProblemType("Produktspezifisch");

        UIEngine.clear();
        UIEngine uiManager = new UIEngine("Produktspezifische Probleme für " + selectedProduct.getName());

        ArrayList<String> issueOptions = new ArrayList<>();
        for (Issue issue : selectedProduct.getProductIssues()) {
            issueOptions.add(issue.getDescription());
        }

        uiManager.drawMenu(issueOptions);
        int issueChoice = UIEngine.getMenuInput(issueOptions.size());

        Issue productIssue = getIssueByChoice(issueChoice);
        productIssue.provideHelp();
        UIEngine.waitForInput();

        ticket.setIssue(productIssue.getDescription());
    }

    private Issue getIssueByChoice(int issueChoice) {
        List<Issue> issueList = selectedProduct.getProductIssues();
        for (Issue issue : issueList) {
            if (issue.getId() == issueChoice) return issue;
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByChoice(int productChoice) {
        for (Product product : products) {
            if (product.getId() == productChoice)
                return product;
        }
        return null;
    }
    private static String getCleanbugSolution(int issueId) {
        return switch (issueId) {
            case 1 -> " -> Überprüfen Sie, ob die Sensoren sauber sind und keine Verschmutzungen vorliegen.\n " +
                    "-> Stellen Sie sicher, dass die Software auf dem neuesten Stand ist.\n" +
                    "-> Passen Sie die Empfindlichkeit der Hinderniserkennung in den Einstellungen an.\n" +
                    "-> Entfernen oder markieren Sie kleine Hindernisse, die der Cleanbug nicht erkennt.";
            case 2 -> "-> Stellen Sie sicher, dass der Akku geladen ist. Falls nicht, laden Sie ihn vollständig auf.\n" +
                    "-> Überprüfen Sie, ob sich das Gerät in einem feuchten oder überhitzten Zustand befindet. Lassen Sie es ggf. abkühlen.\n" +
                    "-> Halten Sie die Ein-/Aus-Taste mindestens 5 Sekunden lang gedrückt.\n" +
                    "-> Prüfen Sie, ob die Sicherung oder das Netzteil defekt ist.";
            case 3 -> "-> Reinigen oder ersetzen Sie die Bürsten und Filter regelmäßig.\n" +
                    "-> Prüfen Sie, ob sich Schmutz in den Ansaugöffnungen befindet und entfernen Sie ihn.\n" +
                    "-> Passen Sie die Reinigungseinstellungen an (z. B. Erhöhung der Saugkraft).\n" +
                    "-> Setzen Sie den Cleanbug auf Werkseinstellungen zurück, falls das Problem weiterhin besteht.";
            default -> "";
        };
    }

    private static String getWindowflySolution(int issueId) {
        return switch (issueId) {
            case 1 -> "-> Überprüfen Sie, ob die Saugnäpfe oder Vakuum-Technologie ordnungsgemäß funktionieren.\n" +
                    "-> Reinigen Sie die Sensoren und die Glasoberfläche, um Haftprobleme zu vermeiden.\n" +
                    "-> Starten Sie das Gerät neu und versuchen Sie einen anderen Modus.\n" +
                    "-> Prüfen Sie die Akkuleistung – ein schwacher Akku kann zu Saugverlust führen.";
            case 2 -> "-> Reinigen Sie die Saugnäpfe und das Fenster gründlich, um optimale Haftung zu gewährleisten.\n" +
                    "-> Prüfen Sie, ob das Gerät für die Fenstertypen (z. B. Doppelglas) geeignet ist.\n" +
                    "-> Achten Sie darauf, dass das Fenster trocken und nicht zu kalt ist.\n" +
                    "-> Nutzen Sie das Sicherheitsseil als Schutzmaßnahme.";
            case 3 -> "-> Laden Sie den Akku vollständig auf oder überprüfen Sie das Netzteil.\n" +
                    "-> Halten Sie die Ein-/Aus-Taste für mindestens 5 Sekunden gedrückt.\n" +
                    "-> Setzen Sie das Gerät zurück, indem Sie es vom Strom trennen und nach 10 Sekunden erneut einschalten.\n" +
                    "-> Prüfen Sie, ob die Firmware auf dem neuesten Stand ist.";
            default -> "";
        };
    }

    private static String getGardenbeetleSolution(int issueId) {
        return switch (issueId) {
            case 1 -> "-> Entfernen Sie lose Gegenstände oder hohe Hindernisse auf der Mähfläche.\n" +
                    "-> Prüfen Sie, ob die Räder blockiert sind oder sich Schmutz angesammelt hat.\n" +
                    "-> Erhöhen Sie die Mähhöhe, wenn das Gras zu hoch ist.\n" +
                    "-> Falls notwendig, setzen Sie Begrenzungsdrähte oder virtuelle Wände ein.";
            case 2 -> "-> Überprüfen Sie, ob die Messer scharf sind und tauschen Sie sie bei Abnutzung aus.\n" +
                    "-> Reinigen Sie den Mähmechanismus regelmäßig, um Verstopfungen zu vermeiden.\n" +
                    "-> Stellen Sie sicher, dass die Mähfläche gleichmäßig ist und keine Löcher oder Hügel aufweist.\n" +
                    "-> Kontrollieren Sie die Einstellungen für Mähhöhe und Fahrweise.";
            case 3 -> "-> Prüfen Sie, ob der Akku geladen ist oder eine Verbindung zur Ladestation besteht.\n" +
                    "-> Halten Sie den Startknopf länger gedrückt (ca. 5 Sekunden).\n" +
                    "-> Kontrollieren Sie die Begrenzungsdrähte, falls das Gerät auf ein Signal angewiesen ist.\n" +
                    "-> Setzen Sie das Gerät auf Werkseinstellungen zurück, falls nichts funktioniert.";
            default -> "";
        };
    }
}
