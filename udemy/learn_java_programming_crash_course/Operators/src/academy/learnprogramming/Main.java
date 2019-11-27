package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

//        double a = 12 * 3 / 4;
//        double b = (12 * 3) / 4;
//        double c = 12 * (3 / 4);
//        System.out.printf("%s %s %s", a, b,  c);
//
//        int x = 12;
//        int y = 3;
//
//        if (x % y == 0) {
//            System.out.printf("divide nicely");
//        } else{
//            System.out.printf("Does not divide nicely");
//        }
//
//        for (int month = 1; month <=12; month++) {
//            System.out.printf("Next month after %s is %s %n", month, month % 12 + 1);
//        }

        int a = 12;
        int b = 7;

//        if (c == 2)
//            System.out.println("found a 2");

        if (b != 0 && divideTwoNumbers(a, b) == 2) {  // short circuiting
            System.out.println("1. found a 2");
        }

        if (b == 0 || divideTwoNumbers(a, b) == 2) {  // short circuiting
            System.out.println("2. found a 2 or 0");
        }
    }

    private static int divideTwoNumbers(int x, int y) {
        // BAD
        return x / y;
    }
}
