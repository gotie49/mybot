package de.mybot.app.service;

import java.util.ArrayList;
import java.util.Scanner;
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

    public void run() {
        Scanner scanner = new Scanner(System.in);

        displayGeneralIssues();
        int issueChoice = scanner.nextInt();
        Issue generalIssue = getIssueByChoice(issueChoice);
        generalIssue.provideHelp();

        scanner.close();
    }

    public void displayGeneralIssues() {
        for (Issue issue : issues) {
            System.out.println(issue.getId() + ". " + issue.getDescription());
        }
    }

    public Issue getIssueByChoice(int issueChoice) {
        for (Issue issue : issues) {
            if (issue.getId() == issueChoice) {
                return issue;
            }
        }
        return null;
    }
}
