package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose an option >>");
        System.out.println("1. Cappuccino");
        System.out.println("2. Latte");
        System.out.println("3. Americano");
        System.out.println("4. Mocha");
        System.out.println("5. Macchiato");
        System.out.println("6. Espresso");
        System.out.println("7. Quit program");

        String userChoice = scanner.nextLine();
        System.out.println("You chose: " + userChoice);

        scanner.close();
    }
}
