package de.mybot.app.service;

import java.util.ArrayList;
import de.mybot.app.data.Issue;
import de.mybot.app.data.Ticket;
import de.mybot.app.utils.UIEngine;

public class GeneralService {
    private final ArrayList<Issue> issues = new ArrayList<>();
    Ticket ticket = Ticket.getInstance();

    public GeneralService() {
        issues.add(new Issue(1, "Verbindungsprobleme"));
        issues.add(new Issue(2, "App-/Softwarefehler"));
        issues.add(new Issue(3, "Einrichtung/Erstinstallation"));
        issues.add(new Issue(4, "Ersatzteile/Bestellung"));
        issues.add(new Issue(5, "Direktes Weiterleiten an Service-Mitarbeiter"));
    }

    public void run() {
        ticket.setProblemType("Allgemein");

        UIEngine.clear();
        UIEngine uiManager = new UIEngine("Allgemeine Probleme");

        ArrayList<String> generalOptions = new ArrayList<>();
        for (Issue issue : issues) {
            generalOptions.add(issue.getDescription());
        }

        uiManager.drawMenu(generalOptions);
        int issueChoice = UIEngine.getMenuInput(generalOptions.size());

        Issue generalIssue = getIssueByChoice(issueChoice);
        generalIssue.provideHelp();
        UIEngine.waitForInput();

        ticket.setIssue(generalIssue.getDescription());
    }

    private Issue getIssueByChoice(int issueChoice) {
        for (Issue issue : issues) {
            if (issue.getId() == issueChoice) return issue;
        }
        return null;
    }
}
