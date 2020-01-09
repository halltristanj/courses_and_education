package academy.learnprogramming;

/**
 * @author Learn Programming Academy Team
 * @see <a href="https://learnprogramming.academy">https://learnprogramming.academy</a>
 */
public class Main {

    public static void main(String[] args) {

        boolean playAgain = true;

        while (playAgain) {
            BitcoinMiner game = new BitcoinMiner();
            game.play();
            playAgain = BitcoinMiner.getYesOrNo("Would you like to play again?");
        }

        System.out.println("Goodbye");
    }
}
