package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

	    double result1 = 0.1 * 8;
	    double result2 = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;

        System.out.printf("result1 is %f%n", result1);
        System.out.printf("result2 is %f%n", result2);

        double difference = result1 - result2;
        System.out.printf("Difference is: %.99f%n", difference);
    }
}
