package de.mybot.app.service;

import java.util.ArrayList;
import java.util.List;
import de.mybot.app.data.Issue;
import de.mybot.app.data.Product;

public class ProductService {
    private final ArrayList<Product> products = new ArrayList<>();

    public ProductService() {
        ArrayList<Issue> cleanbugIssues = new ArrayList<>();
        cleanbugIssues.add(new Issue(1, "Absturz bei Hindernissen"));
        cleanbugIssues.add(new Issue(2, "Gerät startet nicht"));
        cleanbugIssues.add(new Issue(3, "Reinigung nicht effektiv"));

        ArrayList<Issue> windowflyIssues = new ArrayList<>();
        windowflyIssues.add(new Issue(1, "Absturz bei Hindernissen"));
        windowflyIssues.add(new Issue(2, "Gerät startet nicht"));
        windowflyIssues.add(new Issue(3, "Reinigung nicht effektiv"));

        ArrayList<Issue> gardenbeetleIssues = new ArrayList<>();
        gardenbeetleIssues.add(new Issue(1, "Absturz bei Hindernissen"));
        gardenbeetleIssues.add(new Issue(2, "Gerät startet nicht"));
        gardenbeetleIssues.add(new Issue(3, "Reinigung nicht effektiv"));

        Product cleanbug = new Product(1, "Cleanbug", cleanbugIssues);
        Product windowfly = new Product(2, "Windowfly", windowflyIssues);
        Product gardenbeetle = new Product(3, "Gardenbeetle", gardenbeetleIssues);
        products.add(cleanbug);
        products.add(windowfly);
        products.add(gardenbeetle);
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

    public Issue getIssueByChoice(Product selectedProduct, int issueChoice) {
        List<Issue> issueList = selectedProduct.getProductIssues();
        for (Issue issue : issueList) {
            if (issue.getId() == issueChoice) {
                return issue;
            }
        }
        return null;
    }

    public void displayProductIssues(Product product) {
        List<Issue> issueList = product.getProductIssues();
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
