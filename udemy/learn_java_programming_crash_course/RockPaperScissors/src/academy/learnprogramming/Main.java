package academy.learnprogramming;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int ROCK = 0;
    private static final int PAPER = 1;
    private static final int SCISSORS = 2;
    private static Scanner scanner = new Scanner((System.in));

    public static void main(String[] args) {

        Random randomGenerator = new Random();

        String playerChoice;

        do {
            int playerValue = -1;
            int computerValue = randomGenerator.nextInt(3);
            String computerChoice;

            // comment
            if (computerValue == ROCK) {
                computerChoice = "rock";
            } else if (computerValue == PAPER) {
                computerChoice = "paper";
            } else {
                computerChoice = "scissors";
            }

            System.out.println("please enter rock, paper, or scissors to play.");
            playerChoice = scanner.nextLine().toLowerCase();

            if (playerChoice.equals("rock")) {
                playerValue = ROCK;
            } else if (playerChoice.equals("paper")) {
                playerValue = PAPER;
            } else if (playerChoice.equals("scissors")) {
                playerValue = SCISSORS;
            } else {
                System.out.printf("%s is not a valid choice.%n", playerChoice);
            }

            System.out.printf("Computer chose %s | Player chose %s%n", computerChoice, playerChoice);

            if (playerValue == computerValue) {
                System.out.println("Tie.");
            } else if ((playerValue - 1 == computerValue)
                    || (playerValue == ROCK && computerValue == SCISSORS)) {
                System.out.println("Player wins.");
            } else {
                System.out.println("Computer wins.");
            }
        } while (getYesOrNo("Would you like to play again? [y/n]"));

        scanner.close();

    }

    private static boolean getYesOrNo(String question) {

        String answer;

        while (true) {
            System.out.printf("%s%n", question);
            answer = scanner.nextLine();
            answer = answer.toLowerCase();

            if (answer.equals("y")) {
                return true;
            }

            if (answer.equals("n")) {
                return false;
            }
        }
    }
}
