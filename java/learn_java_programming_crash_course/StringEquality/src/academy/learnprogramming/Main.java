package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        String first = "This is a string.";
        String second = new String("This is a string.");

        System.out.println(first == second);
        System.out.println(second == first);
        System.out.println(first.equals(second));
        System.out.println(second.equals(first));
    }
}
