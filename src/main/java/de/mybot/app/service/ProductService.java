package de.mybot.app.service;

import java.util.List;
import java.util.Map;
import de.mybot.app.data.Issue;
import de.mybot.app.data.Product;

public class ProductService {
    private final Map<String, List<String>> productIssues = Map.of(
            "Cleanbug", List.of("Absturz bei Hindernissen", "Gerät startet nicht", "Reinigung nicht effektiv"),
            "Windowfly", List.of("Gerät bleibt am Fenster haften", "Gerät rutscht ab", "Gerät startet nicht"),
            "Gardenbeetle", List.of("Gerät bleibt stecken", "Gerät mäht nicht richtig", "Gerät startet nicht")
    );

    private final Map<Product, List<Issue>> productIssuesNe =
            Map.of(
                    new Product(1, "Cleanbug"), List.of(new Issue(1, "Absturz bei Hindernissen"))
            );

    public String getProductNameByChoice(int choice) {
        return switch (choice) {
            case 1 -> "Cleanbug";
            case 2 -> "Windowfly";
            case 3 -> "Gardenbeetle";
            default -> null;
        };
    }

    public void displayProductIssues(String product) {
        List<String> issues = productIssues.get(product);
        if (issues != null) {
            for (int i = 0; i < issues.size(); i++) {
                System.out.println((i + 1) + ". " + issues.get(i));
            }
        }
    }

    public String getIssueByChoice(String product, int choice) {
        List<String> issues = productIssues.get(product);
        if (issues != null && choice > 0 && choice <= issues.size()) {
            return issues.get(choice - 1);
        }
        return null;
    }

    public void provideHelp(String product, String issue) {
        System.out.println("Hilfsanleitung für " + product + " - Problem: " + issue);
        // Logik für detaillierte Hilfsanleitung
    }
}
