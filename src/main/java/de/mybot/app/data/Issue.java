package de.mybot.app.data;

public class Issue {
    private int id;
    private String description;

    public Issue(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }


}
