package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        StringBuilder first = new StringBuilder("This is a string");

        int a = 12;
        int b = 34;
        int c = 56;

        first.append(' ');
        first.append(a);
        first.append(' ');
        first.append(3.45);
        first.append(' ');
        first.append(a == 12);
        first.append(' ');
        first.append(b > c);
        first.append(" ");
        first.append("Java is great", 8, 13);

        System.out.println(first);
    }
}
