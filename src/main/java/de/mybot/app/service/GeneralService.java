package de.mybot.app.service;

import java.util.ArrayList;
import de.mybot.app.data.Issue;
import de.mybot.app.data.Ticket;
import de.mybot.app.utils.UIEngine;

public class GeneralService {
    private final ArrayList<Issue> issues = new ArrayList<>();
    Ticket ticket = Ticket.getInstance();

    public GeneralService() {
        issues.add(new Issue(1, "Verbindungsprobleme",
                "-> Gerät und Router neustarten.\n" +
                        "-> Sicherstellen, dass das WLAN-Signal stark genug ist.\n" +
                        "-> Gerät in den Netzwerkeinstellungen zurücksetzen und erneut verbinden.\n"));
        issues.add(new Issue(2, "App-/Softwarefehler",
                "-> App neustarten und auf Updates prüfen.\n" +
                        "-> Gerät neustarten und erneut koppeln.\n" +
                        "-> App neu installieren, falls das Problem weiterhin besteht.\n"));
        issues.add(new Issue(3, "Einrichtung/Erstinstallation",
                "-> Anleitung aus der Verpackung befolgen.\n" +
                        "-> Gerät mit der App verbinden und Kalibrierung durchführen.\n"));

        issues.add(new Issue(4, "Ersatzteile/Bestellung",
                "Ersatzteile können produktspezifisch bestellt werden.\n" +
                        "Bitte wählen Sie zuerst Ihr Produkt und das entsprechende Problem.\n" +
                        "Danach können Sie die passenden Ersatzteile bestellen.\n"));

        issues.add(new Issue(5, "Direktes Weiterleiten an Service-Mitarbeiter",
                "Sie werden an einen Support-Mitarbeiter weitergeleitet.\n" +
                        "Bitte halten Sie Ihre Geräte-ID und eine Fehlerbeschreibung bereit.\n"));
    }

    public void run() {
        ticket.setProblemType("Allgemein");

        UIEngine.clear();
        UIEngine generalMenu = new UIEngine("Allgemeine Probleme");

        ArrayList<String> generalOptions = new ArrayList<>();
        for (Issue issue : issues) {
            generalOptions.add(issue.getDescription());
        }

        generalMenu.drawMenu(generalOptions);
        int issueChoice = UIEngine.getMenuInput(generalOptions.size());

        Issue generalIssue = getIssueByChoice(issueChoice);
        generalIssue.provideHelp();

        ticket.setIssue(generalIssue.getDescription());
    }

    public Issue getIssueByChoice(int issueChoice) {
        for (Issue issue : issues) {
            if (issue.getId() == issueChoice) return issue;
        }
        return null;
    }
}
