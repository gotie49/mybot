package de.mybot.app.data;

public class Issue {
    private int id;
    private String description;

    //TODO: vermutlich brauchen wir hier als Eigenschaft die Hilfsanleitung
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

    public void provideHelp() {
        System.out.println("Hier steht die Hilfsanleitung");
    }


}
