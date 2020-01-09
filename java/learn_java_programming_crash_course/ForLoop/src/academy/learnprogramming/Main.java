package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

	    for(int i=0; i<10; i+=2) {
            System.out.printf("row: %d ", i);
	        for(int j=0; j<10; j+=2) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
