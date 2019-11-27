package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        double a = 12 * 3 / 4;
        double b = (12 * 3) / 4;
        double c = 12 * (3 / 4);
        System.out.printf("%s %s %s", a, b,  c);

        int x = 12;
        int y = 3;

        if (x % y == 0) {
            System.out.printf("divide nicely");
        } else{
            System.out.printf("Does not divide nicely");
        }

        for (int month = 1; month <=12; month++) {
            System.out.printf("Next month after %s is %s %n", month, month % 12 + 1);
        }
    }
}
