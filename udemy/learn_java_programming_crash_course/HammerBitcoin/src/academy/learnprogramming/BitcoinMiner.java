package academy.learnprogramming;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Learn Programming Academy Team
 * @see <a href="https://learnprogramming.academy">https://learnprogramming.academy</a>
 */
public class BitcoinMiner {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    private static Random randomGenerator = new Random();
    private static Scanner scanner = new Scanner(System.in);

    private int year = 1;
    private int employees = 100;
    private int cash = 2800;
    private int computers = 1000;
    private int computerPrice;

    private int starved = 0;
    private int marketCrashVictims = 0;
    private int newEmployees = 5;
    private int cashMined = 3000;
    private int bitcoinGeneratedPerComputer = 3;
    private int amountStolenByHackers = 200;

    private int cashPaidToEmployees;
    private int computersMaintained;

    private static final String OGH = "O Great Gill Bates";

    /**
     * Prints the introductory paragraph.
     */
    public void printIntroductoryParagraph() {
        System.out.println("Congratulations! You are the newest CEO of Make Me Rich, Inc, elected for a ten year term.");
        System.out.println("Your duties are to dispense living expenses for employees, direct mining of bitcoin, and");
        System.out.println("buy and sell computers as needed to support the corporation.");
        System.out.println("Watch out for hackers and market crashes!");
        System.out.println();
        System.out.println("Cash is the general currency, measured in bitcoins.");
        System.out.println();
        System.out.println("The following will help you in your decisions:");
        System.out.println("   * Each employee needs at least 20 bitcoins converted to cash per year to survive");
        System.out.println("   * Each employee can maintain at most 10 computers");
        System.out.println("   * It takes 2 bitcoins to pay for electricity to mine bitcoin on a computer.");
        System.out.println("   * The market price for computers fluctuates yearly");
        System.out.println();
        System.out.println("Lead the team wisely and you will be showered with appreciation at the end of your term.");
        System.out.println("Do it poorly and you will be terminated!");
    }

    /**
     * Allows the user to play the game.
     */
    public void play() {
        boolean stillInOffice = true;

        printIntroductoryParagraph();

        while (year <= 10 && stillInOffice) {
            computerPrice = updateComputerPrice();
            printSummary();
            buyComputers();
            sellComputers();
            payEmployees();
            maintainComputers();

            marketCrashVictims = checkForCrash();
            employees = employees - marketCrashVictims;

            if (countStarvedEmployees() >= 45) {
                stillInOffice = false;
            }

            newEmployees = countNewHires();
            employees += newEmployees;
            cash += mineBitcoin(computersMaintained);
            checkForHackers();
            computerPrice = updateComputerPrice();
            year = year + 1;
        }
        printFinalScore();
    }

    /**
     * Prints the year-end summary.
     */
    private void printSummary() {
        System.out.print(ANSI_YELLOW);
        System.out.println("___________________________________________________________________");
        System.out.println("\n" + OGH + "!");
        System.out.printf("You are in year %s of your ten year rule.%n", year);

        if (marketCrashVictims > 0) {
            System.out.printf("A terrible market crash wiped out %s of your team.%n", marketCrashVictims);

        }
        System.out.printf("In the previous year %s of your team starved to death.%n", starved);
        System.out.printf("In the previous year %s employee(s) got employed by the corporation.%n", newEmployees);
        System.out.printf("The employee head count is now " + employees + "%n");
        System.out.printf("We mined %s bitcoins at %s bitcoins per computer. %n", cashMined, bitcoinGeneratedPerComputer);

        if (amountStolenByHackers > 0) {
            System.out.printf("*** Hackers stole %s bitcoins, leaving %s bitcoins in your online wallet.%n", amountStolenByHackers, cash);
        } else {
            System.out.printf("We have %s bitcoins of cash in storage.%n", cash);
        }
        System.out.printf("The corporation owns %s computers for mining.%n", computers);
        System.out.printf("Computers currently cost %s bitcoins each.%n", computerPrice);
        System.out.println();
        System.out.print(ANSI_RESET);
    }

    /**
     * Allows the player to buy computers.
     * <p>
     * If a valid amount is entered, the available cash is reduced accordingly.
     */
    private void buyComputers() {
        int computersToBuy;
        String question = "How many computers will you buy? ";

        computersToBuy = getNumber(question);
        int cost = computerPrice * computersToBuy;

        while (cost > cash) {
            jest(String.format("We have but %s bitcoins of cash, not %s!", cash, cost));
            computersToBuy = getNumber(question);
            cost = computerPrice * computersToBuy;
        }
        cash = cash - cost;
        computers = computers + computersToBuy;
        System.out.printf("%s, you now have %s computers %n", OGH, computers);
        System.out.printf("and %s bitcoins of cash.%n", cash);
    }

    /**
     * Tells player that the request cannot be fulfilled.
     *
     * @param message The reason the request cannot be fulfilled.
     */
    private void jest(String message) {
        System.out.printf("%s, you are dreaming!%n", OGH);
        System.out.println(message);
    }

    /**
     * Allows the player to sell computers.
     * <p>
     * Available cash will be increased by the value of the computers sold.
     */
    private void sellComputers() {
        String question = "How many computers will you sell? ";
        int computersToSell = getNumber(question);

        while (computersToSell > computers) {
            jest(String.format("The corporation has only %s computers!", computers));
            computersToSell = getNumber(question);
        }
        cash = cash + computerPrice * computersToSell;
        computers = computers - computersToSell;
        System.out.printf("%s, you now have %s computers%n", OGH, computers);
        System.out.printf("and %s bitcoins of cash.%n", cash);
    }

    /**
     * Allows the player to decide how much cash to use to feed people.
     * <p>
     * If a valid amount is entered, the available cash is reduced accordingly.
     */
    private void payEmployees() {
        String question = "How much bitcoin will you distribute to the employees? ";
        cashPaidToEmployees = getNumber(question);

        while (cashPaidToEmployees > cash) {
            jest(String.format("We have but %s bitcoins!", cash));
            cashPaidToEmployees = getNumber(question);
        }
        cash = cash - cashPaidToEmployees;
        System.out.printf("%s, %s bitcoins remain.%n", OGH, cash);
    }

    /**
     * Allows the user to choose how much to spend on maintenance.
     */
    private void maintainComputers() {
        String question = "How many bitcoins will you allocate for maintenance? ";
        int maintenanceAmount = 0;
        boolean haveGoodAnswer = false;

        while (!haveGoodAnswer) {
            maintenanceAmount = getNumber(question);
            if (maintenanceAmount > cash) {
                jest(String.format("We have but %s bitcoins left!", cash));
            } else if (maintenanceAmount > 2 * computers) {
                jest(String.format("We have but %s computers available for mining!", computers));
            } else if (maintenanceAmount > 20 * employees) {
                jest(String.format("We have but %s people to maintain the computers!", employees));
            } else {
                haveGoodAnswer = true;
            }
        }
        computersMaintained = maintenanceAmount / 2;
        // Be nice to the player!  If they enter an odd number, give them the extra bitcoin back.
        cash = cash - computersMaintained * 2;  // can re-write as cash -= computersMaintained * 2;
        System.out.printf("%s, we now have %s bitcoins in storage.%n", OGH, cash);
    }

    /**
     * Checks for crash, and counts the victims.
     *
     * @return The number of victims of the crash.
     */
    private int checkForCrash() {
        int victims;

        if (randomGenerator.nextDouble() < 0.15) {
            System.out.println("*** A terrible market crash wipes out half of the corporation's employees! ***");
            victims = employees / 2;
        } else {
            victims = 0;
        }
        return victims;
    }

    /**
     * Counts how many people starved, and removes them from the employees.
     *
     * @return The percent of employees who starved.
     */
    private int countStarvedEmployees() {  // TODO: Has side effects
        int employeesPaid = cashPaidToEmployees / 20;
        int percentStarved = 0;

        if (employeesPaid >= employees) {
            starved = 0;
            System.out.print(ANSI_GREEN);
            System.out.println("The corporation's employees are well fed and happy.");
        } else {
            starved = employees - employeesPaid;
            System.out.print(ANSI_RED);
            System.out.printf("%s employees starved to death.%n", starved);
            percentStarved = (100 * starved) / employees;
            employees = employees - starved;
        }
        System.out.print(ANSI_RESET);
        return percentStarved;
    }

    /**
     * Counts how many new employees joined the company.
     *
     * @return The number of new hires.
     */
    private int countNewHires() {
        int newEmployees;

        if (starved > 0) {
            newEmployees = 0;
        } else {
            newEmployees = (20 * computers + cash) / (100 * employees) + 1;
        }
        return newEmployees;
    }

    /**
     * Determines the harvest, and collects the new cash.
     * <p>
     * Computers mine a random number of bitcoin each year, from 1 to 5.
     *
     * @return The amount of bitcoin mined.
     */
    private int mineBitcoin(int computers) {
        bitcoinGeneratedPerComputer = randomGenerator.nextInt(5) + 1;
        cashMined = bitcoinGeneratedPerComputer * computers;
        return cashMined;
    }

    /**
     * Checks if hackers get into the system, and determines how much they stole.
     */
    private void checkForHackers() {
        if (randomGenerator.nextInt(100) < 40) {
            int percentHacked = 10 + randomGenerator.nextInt(21);
            System.out.printf("*** Hackers steal %s percent of your bitcoins! ***%n", percentHacked);
            amountStolenByHackers = (percentHacked * cash) / 100;
            cash = cash - amountStolenByHackers;
        } else {
            amountStolenByHackers = 0;
        }
    }

    /**
     * Randomly sets the new price of computers.
     *
     * @return The new price of a computer.
     * <p>
     * The price fluctuates from 17 to 26 bitcoin per computer.
     */
    private int updateComputerPrice() {
        return 17 + randomGenerator.nextInt(10);
    }

    /**
     * Prints an evaluation at the end of a game.
     */
    private void printFinalScore() {
        if (starved >= (45 * employees) / 100) {
            System.out.print(ANSI_RED);
            System.out.println("O Once-Great Hammurabi,");
            System.out.printf("%s of your team starved during the last year of your incompetent reign!%n", starved);
            System.out.println("The few who remain hacked your bank account and changed your password, effectively evicting you!");
            System.out.println();
            System.out.println("Your final rating: TERRIBLE.");
            System.out.print(ANSI_RESET);
            return;
        }

        int computerScore = computers;
        if (20 * employees < computerScore) {
            computerScore = 20 * employees;
        }

        if (computerScore < 600) {
            System.out.printf("Congratulations, %s%n", OGH);
            System.out.println("You have ruled wisely but not well.");
            System.out.println("You have led your people through ten difficult years,");
            System.out.printf("but your corporations assets have shrunk to a mere %s computers.%n", computers);
            System.out.println();
            System.out.println("Your final rating: ADEQUATE.");
        } else if (computerScore < 800) {
            System.out.print(ANSI_YELLOW);
            System.out.printf("Congratulations, %s.%n", OGH);
            System.out.println("You  have ruled wisely, and shown the online world that its possible to make money in cryptocurrency.");
            System.out.println();
            System.out.println("Your final rating: GOOD.");
        } else {
            System.out.print(ANSI_GREEN);
            System.out.printf("Congratulations, %s%n", OGH);
            System.out.println("You  have ruled wisely and well, and expanded your holdings while keeping your team happy.");
            System.out.println("Altogether, a most impressive job!");
            System.out.println();
            System.out.println("Your final rating: SUPERB.");
        }
        System.out.print(ANSI_RESET);
    }

    /**
     * Prints the given message (which should ask the user for some integral
     * quantity), and returns the number entered by the user. If the user's
     * response isn't an integer, the question is repeated until the user does
     * give an integer response.
     *
     * @param message The request to present to the user.
     * @return The user's numeric response.
     */
    private int getNumber(String message) {
        while (true) {
            System.out.print(message);
            String userInput = scanner.nextLine();
            try {
                return Integer.parseInt(userInput);
            } catch (Exception ignored) {
                System.out.printf("%s isn't a number!%n", userInput);
            }
        }
    }

    /**
     * Returns a boolean response to a yes/no question.
     *
     * @param question The question to be asked.
     * @return True if the answer was yes, False if no.
     */
    public static boolean getYesOrNo(String question) {
        String answer;

        while (true) {  // infinite loop.  return will exit the method, thus terminating the loop
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
