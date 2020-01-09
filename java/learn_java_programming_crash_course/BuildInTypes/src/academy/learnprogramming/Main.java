package academy.learnprogramming;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
//        System.out.printf("byte min: %s | max: %s%n", Byte.MIN_VALUE, Byte.MAX_VALUE);
//        System.out.printf("short min: %s | max: %s%n", Short.MIN_VALUE, Short.MAX_VALUE);
//        System.out.printf("integer min: %s | max: %s%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
//        System.out.printf("long min: %s | max: %s%n", Long.MIN_VALUE, Long.MAX_VALUE);

        float f = 123.456789012345678f;
        double d = 123.456789012345678;
        System.out.printf("f is %.99f %n", f);
        System.out.printf("d is %.99f %n", d);

        BigDecimal z = new BigDecimal("123.45678901234567890123456789012345678");
        System.out.printf("z is %.99f%n", z);
    }
}
