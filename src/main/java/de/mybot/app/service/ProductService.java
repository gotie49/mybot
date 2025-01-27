package de.mybot.app.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import de.mybot.app.data.Issue;
import de.mybot.app.data.Product;

public class ProductService {
    /*private final Map<String, List<String>> productIssues = Map.of(
            "Cleanbug", List.of("Absturz bei Hindernissen", "Gerät startet nicht", "Reinigung nicht effektiv"),
            "Windowfly", List.of("Gerät bleibt am Fenster haften", "Gerät rutscht ab", "Gerät startet nicht"),
            "Gardenbeetle", List.of("Gerät bleibt stecken", "Gerät mäht nicht richtig", "Gerät startet nicht")
    );*/
    private final LinkedHashMap<Product, List<Issue>> productIssues = new LinkedHashMap<>();
    ArrayList<Product> productList = new ArrayList<>(productIssues.keySet());

    public ProductService() {
        productIssues.put(new Product(1, "Cleanbug"), List.of(new Issue(1, "Absturz bei Hindernissen")));
        productIssues.put(new Product(2, "Windowfly"), List.of(new Issue(1, "Absturz bei Hindernissen")));
        productIssues.put(new Product(3, "Gardenbeetle"), List.of(new Issue(1, "Absturz bei Hindernissen")));
    }

    public List<Product> getProducts() {
        return new ArrayList<>(productIssues.keySet());
    }


    public Product getProductByChoice(int productChoice) {
        for (Product product : productList) {
            if (product.getId() == productChoice)
                return product;
        }
        return null;
    }

    public Issue getIssueByChoice(Product selectedProduct, int issueChoice) {
        List<Issue> issueList = productIssues.get(selectedProduct);
        for (Issue issue : issueList) {
            if (issue.getId() == issueChoice) {
                return issue;
            }
        }
        return null;
    }

    public void displayProductIssues(Product product) {
        List<Issue> issueList = productIssues.get(product);
        for (Issue issue : issueList) {
            System.out.println(issue.getId() + ". " + issue.getDescription());
        }
    }

    public void provideHelp(Product product, Issue productIssue) {
        switch (product.getId()) {
            case 1:
                provideHelpWindowfly(productIssue);
                break;
        }
    }

    private void provideHelpWindowfly(Issue productIssue) {
        switch (productIssue.getId()) {
            case 1:
                System.out.println("your mom");
                break;
        }
    }
}
