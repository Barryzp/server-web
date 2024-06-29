package xyz.barry.car;

public class BYDCar extends Car {
    @Override
    public void startEngine() {
        System.out.println("BYD car start!");
    }

    @Override
    public void move() {
        System.out.println("BYD car Fucking move!");
    }
}
