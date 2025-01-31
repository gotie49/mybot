package de.mybot.app.utils;

import java.util.ArrayList;
import java.util.Scanner;

public class UIEngine {
    private final String name;
    private static final Scanner scanner = new Scanner(System.in);

    public UIEngine(String name) {
        this.name = name;
    }

    public void drawMenu(ArrayList<String> options) {
        //find the biggest string within the options list 
        int maxLength = 0;
        for (String option : options) {
            int optionLength = option.length() + 3;
            if (optionLength > maxLength) {
                maxLength = optionLength;
            }
        }
        maxLength += 4;

        int headerLength = "--------------- ".length() + name.length() + " ----------------".length();
        int totalLength = Math.max(headerLength, maxLength * 2);

        StringBuilder header = new StringBuilder("--------------- " + name + " ----------------");
        while (header.length() < totalLength) {
            header = new StringBuilder("-" + header + "-");
        }

        System.out.println(header);

        for (int i = 0; i < options.size(); i += 2) {
            String firstOption = (i + 1) + ") " + options.get(i);
            // Create the second option string if it exists, otherwise an empty string
            String secondOption = (i + 2 <= options.size()) ? (i + 2) + ") " + options.get(i + 1) : "";

            // Print the two options with formatted output, aligning the second column
            System.out.printf("%-" + maxLength + "s %s%n", firstOption, secondOption);
        }
    }

    public static String fetchUserInput(boolean showInputField) {
        if (showInputField) {
            System.out.print("Eingabe: ");
        }
        String input = scanner.next();
        scanner.nextLine(); //consume remaining buffer
        System.out.println();
        return input;
    }

    public static int getMenuInput(int menuSize) {
        String response = fetchUserInput(true);
        try {
            int input = Integer.parseInt(response);
            if (input > menuSize || input < menuSize) {
                System.out.println("Ungültige Eingabe: Die Zahl ist größer/kleiner als die Anzahl an Menüoptionen, Eingabe: " + input);
                return getMenuInput(menuSize);
            }
            return input;
        } catch (NumberFormatException e) {
            System.out.println("Ungültige Eingabe: Der eingegebene Wert ist keine Zahl, Eingabe: " + response);
            return getMenuInput(menuSize);
        }
    }

    public static boolean getUserResponse(String msg) {
        System.out.println(msg + " J oder N?");
        String response = fetchUserInput(true);
        if (response.equalsIgnoreCase("J")) {
            return true;
        } else if (response.equalsIgnoreCase("N")) {
            return false;
        } else {
            System.out.println("Bitte geben Sie entweder J/j oder N/n ein. Eingabe war " + response);
            return getUserResponse(msg);
        }
    }

    public static void clear() {
        System.out.println("DEBUG: SCREEN CLEARED");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void waitForInput() {
        System.out.println("DEBUG: WAITING FOR INPUT");
        scanner.nextLine();
    }
}
