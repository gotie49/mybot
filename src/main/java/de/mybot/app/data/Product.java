package de.mybot.app.data;

import java.util.ArrayList;

public class Product {
    private int id;
    private String name;
    private ArrayList<Issue> productIssues;

    public Product(int id, String name, ArrayList<Issue> productIssues) {
        this.id = id;
        this.name = name;
        this.productIssues = productIssues;
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
}
