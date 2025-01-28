package de.mybot.app.data;

import java.util.ArrayList;

public class Product {
    private final int id;
    private final String name;
    private final ArrayList<Issue> productIssues;
    private final ArrayList<String> spareparts;

    public Product(int id, String name, ArrayList<Issue> productIssues, ArrayList<String> spareparts) {
        this.id = id;
        this.name = name;
        this.productIssues = productIssues;
        this.spareparts = spareparts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Issue> getProductIssues() {
        return productIssues;
    }

    public ArrayList<String> getSpareparts() {
        return spareparts;
    }
}
