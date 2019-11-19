package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userChoice;

        System.out.println("Please choose an option >>");
        System.out.println("1. Cappuccino");
        System.out.println("2. Latte");
        System.out.println("3. Americano");
        System.out.println("4. Mocha");
        System.out.println("5. Macchiato");
        System.out.println("6. Espresso");
        System.out.println("Q. Quit program");

        do {

            userChoice = scanner.nextLine();
            userChoice = userChoice.toLowerCase();
            System.out.println("You chose: " + userChoice);

            switch (userChoice) {
                case "1":
                case "2":
                    System.out.println("Making latte...");
                    System.out.println("Make espresso.");
                    System.out.println("Steam milk.");
                    System.out.println("Add milk to espresso.");
                    break;
                case "3":
                    System.out.println("Making Americano");
                    break;
                case "4":
                    System.out.println("Making mocha");
                    break;
                case "5":
                    System.out.println("Making Macchiato");
                    break;
                case "6":
                    System.out.println("Making espresso");
                    break;
                default:
                    System.out.println("Returning coins.");
                    continue;
            }

            System.out.println("Dispensing coffee.");
            System.out.println("Have a nice day.");

        } while (!userChoice.equals("q"));

        scanner.close();
    }
}
