package de.mybot.app.data;

import de.mybot.app.utils.UIEngine;

public class Issue {
    private final int id;
    private final String description;
    private final String helpInstructions;

    public Issue(int id, String description, String helpInstructions) {
        this.id = id;
        this.description = description;
        this.helpInstructions = helpInstructions;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void provideHelp() {
        UIEngine.clear();
        System.out.println(helpInstructions);
        UIEngine.waitForInput();
    }
}
