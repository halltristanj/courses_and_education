package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        int apples = 6;
        int oranges = 9;
        double applePrice = 12.60;
        double orangePrice = 4.50;

        boolean moreApples;
        boolean applesAreDearer;

        moreApples = (apples > oranges);
        applesAreDearer = (applePrice > orangePrice);
        System.out.printf("We have more apples: %s %n", moreApples);
        System.out.printf("Apples are dearer: %s %n", applesAreDearer);

        System.out.printf("Reducing cost of apples: %s %n", (moreApples && applesAreDearer));
        System.out.printf("Reducing cost of apples: %s %n", (moreApples || applesAreDearer));
    }
}
