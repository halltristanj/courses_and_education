package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What day is it?");
        String day = scanner.nextLine();
        String howToSpendTime;

//        if (day.toLowerCase().equals("saturday")) {
//            howToSpendTime = "Relax";
//        } else {
//            howToSpendTime = "Work";
//        }

        howToSpendTime = day.toLowerCase().equals("saturday") ? "Relax" : "Work";

        System.out.printf("%s on %s %n", howToSpendTime, day);
        scanner.close();
    }
}
