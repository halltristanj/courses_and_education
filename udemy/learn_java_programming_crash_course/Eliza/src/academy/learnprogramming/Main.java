package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	    var scanner = new Scanner(System.in);

	    System.out.println(Doctor.intro());

//	    var userInput = "";
		String userInput;

//		while(!userInput.equalsIgnoreCase("quit")) {
	    do {
	    	userInput = scanner.nextLine();
	    	String response = Doctor.response(userInput);
	    	System.out.println(response);
		} while(!userInput.equalsIgnoreCase("quit"));

	    scanner.close();
    }
}
