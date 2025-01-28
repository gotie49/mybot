package de.mybot.app.service;

import java.util.ArrayList;
import de.mybot.app.data.Issue;

public class GeneralService {

    private ArrayList<Issue> issues = new ArrayList<>();

    public GeneralService() {
        issues.add(new Issue(1, "Verbindungsprobleme"));
        issues.add(new Issue(2, "App-/Softwarefehler"));
        issues.add(new Issue(3, "Einrichtung/Erstinstallation"));
        issues.add(new Issue(4, "Ersatzteile/Bestellung"));
        issues.add(new Issue(5, "Direktes Weiterleiten an Service-Mitarbeiter"));
    }

    public Issue getIssueByChoice(int issueChoice) {
        for (Issue issue : issues) {
            if (issue.getId() == issueChoice) {
                return issue;
            }
        }
        return null;
    }

    public void displayGeneralIssues() {
        for (Issue issue : issues) {
            System.out.println(issue.getId() + ". " + issue.getDescription());
        }
    }

    public void provideHelp(Issue generalIssue) {
        System.out.println("Hilfe!!! für" + generalIssue.getDescription());
        switch (generalIssue.getId()) {
            case 1:
                System.out.println("Hilfsanleitung für Issue1");
                break;
            case 2:
                System.out.println("Hilfsanleitung für Issue2");
                break;
            case 3:
                System.out.println("Hilfsanleitung für Issue3");
                break;
            case 4:
                System.out.println("Hilfsanleitung für Issue4");
                break;
            case 5:
                System.out.println("Hilfsanleitung für Issue5");
                break;
            default:
                System.out.println("Kein gültiges Issue");
                break;
        }
        //Issue unspezifische Hinweise die immer im Anschluss folgen sollen
    }
}
