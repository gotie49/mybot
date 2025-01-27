package de.mybot.app.service;

import java.util.List;
import de.mybot.app.data.Issue;

public class GeneralService {
    private final List<Issue> generalIssues =
            List.of(new Issue(1, "Verbindungsprobleme"),
                    new Issue(2, "App-/Softwarefehler"),
                    new Issue(3, "Einrichtung/Erstinstallation"),
                    new Issue(4, "Ersatzteile/Bestellung"),
                    new Issue(5, "Direktes Weiterleiten an Service-Mitarbeiter"));

    public void displayGeneralIssues() {
    }

    public String getIssueByChoice(int issueChoice) {
        return null;
    }

    public void provideHelp(Issue generalIssue) {
        System.out.println("Hilfe!!! für" + generalIssue.toString());
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
