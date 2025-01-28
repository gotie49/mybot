package de.mybot.app.data;

public class Issue {
    private final int id;
    private final String description;
    private final String helpInstructions;

    //TODO: vermutlich brauchen wir hier als Eigenschaft die Hilfsanleitung
    public Issue(int id, String description) {
        this.id = id;
        this.description = description;
        this.helpInstructions = "Not implemented yet";
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void provideHelp() {
        System.out.println(helpInstructions);
    }
}
