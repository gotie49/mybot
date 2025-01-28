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
}
