class Vehicle{
    protected String color;
    protected int maxspeed;
    protected int numwheels;
    protected int currentspeed = 0;

    public Vehicle(String color, int maxspeed, int numwheels){
        this.color = color;
        this.maxspeed = maxspeed;
        this.numwheels = numwheels;
    }
    public void display(){
        System.out.println(color + " " + maxspeed + " " + numwheels);

    }

    public void accelerate(int speed){
        currentspeed += speed;
        System.out.println(currentspeed);
    }

    public void brake(int speed){
        currentspeed -= speed;
        if(currentspeed < 0){
            currentspeed = 0;
        }
        System.out.println(currentspeed);
    }
}

class Car extends Vehicle{
    private int numdoors;

    public void displaynumdoors(){
        System.out.println(numdoors);
    }

    public Car(String color, int maxspeed, int numwheels, int numdoors){
        super(color, maxspeed, numwheels);
        this.numdoors = numdoors;
    }

    @Override
    public void accelerate(int speed){
        super.accelerate(speed);
        System.out.println("Car accelerating");
    }

    @Override
    public void brake(int speed){
        super.brake(speed);
        System.out.println("Car is braking");
    }
}

abstract class ElectricVehicle extends Vehicle{
    public ElectricVehicle(String color, int maxspeed, int numwheels){
        super(color, maxspeed, numwheels);
    }
    public abstract void chargebattery(int percentage);
}

class Electriccar extends ElectricVehicle{
    public Electriccar(String color, int maxspeed, int numwheels){
        super(color, maxspeed, numwheels);
    }

    @Override
    public void chargebattery(int percentage){
        System.out.println("Car charging: "+percentage+"%");
    }
}

interface Fuelefficient{
    public void fuelefficiency(double distance, double consumed);
}

class hybridcar extends ElectricVehicle implements Fuelefficient{
    int numdoors;
    public hybridcar(String color, int maxspeed, int numwheels, int numdoors){
        super(color, maxspeed, numwheels);
        this.numdoors = numdoors;
    }

    public void displaydoors(){
        System.out.println(numdoors);
    }

    @Override
    public void chargebattery(int percentage){
        System.out.println("Hybrid car charging: "+percentage+"%");

    }

    @Override
    public void fuelefficiency(double distance, double consumed){
        double efficiency = distance/consumed;
        System.out.println("Efficiency: "+efficiency+" km/l");
    }
}

public class testveh{
    public static void main(String[] args) {
        Car car = new Car("Red", 200, 4, 4);
        car.displaynumdoors();
        car.accelerate(50);
        car.brake(20);
        car.display();

        Electriccar ecar = new Electriccar("Blue", 150, 4);
        ecar.chargebattery(80);
        ecar.accelerate(60);
        ecar.brake(30);
        ecar.display();

        hybridcar hcar = new hybridcar("Grey" , 180, 4, 4);
        hcar.chargebattery(70);
        hcar.fuelefficiency(500, 10);
        hcar.display();
    }
}
