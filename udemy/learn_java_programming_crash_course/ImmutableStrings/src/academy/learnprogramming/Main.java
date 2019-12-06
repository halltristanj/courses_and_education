package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        StringBuilder first = new StringBuilder("This is a string");
        StringBuilder second = new StringBuilder("This is a string");

//        System.out.printf("first: %s%n", first);
//
//        System.out.println("clearing first");
//        first.delete(0, first.length());
//        System.out.printf("first: *%s* %n", first);
//
//        first.append("Another string");
//        System.out.printf("first: *%s* %n", first);

        System.out.println(first);
        var a = first.delete(0, first.length());
        System.out.println(a);
        System.out.println(a == first);
        System.out.println(a.equals(first));
        System.out.println(first);
        System.out.println(a);
    }
}
