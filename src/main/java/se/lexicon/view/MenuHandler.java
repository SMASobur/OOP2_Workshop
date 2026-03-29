package se.lexicon.view;

import java.util.Scanner;

class MenuHandler {
    private Scanner scanner;

    public MenuHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    //Prints the interactive main menu options to the console.
    public void displayMainMenu() {
        System.out.println("\n=== MENU ⫶☰ ===");
        System.out.println("1. \uD83E\uDE99✚ Insert the Coin");
        System.out.println("2. \uD83D\uDCB0 Check your Balance");
        System.out.println("3. \uD83D\uDED2 Purchase a Product");
        System.out.println("4. \uD83E\uDE99▬ Return your Change");
        System.out.println("5. \uD83D\uDCE6 View available Products");
        System.out.println("0. ➜] EXIT");
        System.out.print("Choose an option: ");
    }

}
