package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	    Car myCar = new Car("Steve");
	    Car anotherCar = new Car("Another Car");

	    myCar.accelerate(5);
        myCar.accelerate(1);
        myCar.accelerate(7);
        myCar.accelerate(8);
        myCar.accelerate(4);
	    myCar.brake(100);
        myCar.accelerate(500);

        anotherCar.brake(50);
    }
}

class Car {

    private int speed = 0;
    private String name;

    public Car(String carName) {
        name = carName;
    }

    public void accelerate(int amount) {
        speed += amount;
        showSpeed();
    }

    public void brake(int amount) {
        speed = speed < amount ? 0 : speed - amount;
        showSpeed();
    }

    private void showSpeed() {
        System.out.printf("%s is going %d km/h%n", name, speed);
    }


}