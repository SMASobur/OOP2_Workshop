package se.lexicon.view;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);



    private static MenuHandler menuHandler = new MenuHandler(scanner);

    static void main() {

        int choice;
        do {
            menuHandler.displayMainMenu();
            choice = GetUserChoice.getInt(scanner, "Choice: ");

            switch (choice){
                case 1:
                    System.out.println("Select 1");
                    break;
                case 2:
                    System.out.println("Select 2");
                    break;
                case 0:
                    System.out.println("...*ੈ✩༺ Goodbye ༻*ੈ✩...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-2 or 0 to Exit.");
            }
        } while (choice!=0);
    }
}
