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

    public void displaydetails(){
        System.out.println("color: " + color + ", Max speed: " + maxspeed + " km/hr, Wheels: " + numwheels);
    }

    public void accelerate(int speedincrease){
        currentspeed += speedincrease;
        System.out.println("Vehicle accelerated. current speed is: " + currentspeed + "km/hr");
    }

    public void brake(int speeddecrease){
        currentspeed -= speeddecrease;
        if (currentspeed < 0){
            currentspeed = 0;
        }
        System.out.println("Vehicle speed decreased. Current speed is " + currentspeed + "km/hr");
    }
}

class Car extends Vehicle{
    private int numdoors;

    public void displayNumDoors() {
        System.out.println("Number of doors: " + numdoors);
    }

    public Car(String color, int maxspeed, int numwheels, int numdoors){
        super(color, maxspeed, numwheels);
        this.numdoors = numdoors;
    }

    @Override
    public void accelerate(int speedincrease){
        super.accelerate(speedincrease);
        System.out.println("Car is accelerating smoothly");
    }

    @Override
    public void brake(int speeddecrease){
        super.brake(speeddecrease);
        System.out.println("Car is braking safely");
    }
    
}

class Truck extends Vehicle{
    private int payload;

    public void displayPayload(){
        System.out.println("Payload: " + payload + "kg");
    }

    public Truck(String color, int maxspeed, int numwheels, int payload){
        super(color, maxspeed, numwheels);
        this.payload = payload;
    }

    @Override
    public void accelerate(int speedincrease){
        super.accelerate(speedincrease);
        System.out.println("Truck is accelerating slowly");
    }

    @Override
    public void brake(int speeddecrease){
        super.brake(speeddecrease);
        System.out.println("Truck is braking slowly");
    }
}

abstract class Electricvehicle extends Vehicle{
    public Electricvehicle(String color, int maxspeed, int numwheels){
        super(color, maxspeed, numwheels);
    }

    public abstract void chargebattery(int percentage);
}

class Electriccar extends Electricvehicle{
    public Electriccar(String color, int maxspeed, int numwheels){
        super(color, maxspeed, numwheels);
    }

    @Override
    public void chargebattery(int percentage){
        System.out.println("Electric car charging: " + percentage + "% charged");
    }
}

interface Fuelefficient{
    double calculatefuelefficiency(double distance, double fuelconsumed);
}

class Hybridcar extends Electricvehicle implements Fuelefficient{
    
    private int numdoors;

    public Hybridcar(String color, int maxspeed, int numwheels, int numdoors){
        super(color, maxspeed, numwheels);
        this.numdoors = numdoors;
    }

    public void displayNumDoors() {
        System.out.println("Number of doors: " + numdoors);
    }

    @Override
    public double calculatefuelefficiency(double distance, double fuelconsumed) {
        return distance / fuelconsumed;
    }

    @Override
    public void chargebattery(int percentage){
        System.out.println("hybrid car charging: " + percentage + "% charged");
    }
}

class Motorcycle extends Vehicle{
    public Motorcycle(String color, int maxspeed, int numwheels){
        super(color, maxspeed, numwheels);
    }

    @Override
    public void accelerate(int speedincrease){
        super.accelerate(speedincrease);
        System.out.println("Motorcycle is accelerating very fast");
    }

    @Override
    public void brake(int speeddecrease){
        super.brake(speeddecrease);
        System.out.println("Motorcycle is braking very fast");
    }
}
// Test class
public class TestVehicle {
    public static void main(String[] args) {
        Car car = new Car("Red", 200, 4, 4);
        Truck truck = new Truck("Blue", 120, 6, 10000);
        Electriccar eCar = new Electriccar("Green", 180, 4);
        Hybridcar hybridCar = new Hybridcar("Silver", 160, 4, 4);
        Motorcycle bike = new Motorcycle("Black", 220, 2);

        System.out.println("\n--- Vehicle Details ---");
        car.displaydetails();
        truck.displaydetails();
        eCar.displaydetails();
        hybridCar.displaydetails();
        bike.displaydetails();

        System.out.println("\n--- Testing Acceleration and Braking ---");
        car.accelerate(50);
        truck.accelerate(30);
        eCar.accelerate(40);
        hybridCar.accelerate(60);
        bike.accelerate(80);

        car.brake(20);
        truck.brake(10);
        eCar.brake(30);
        hybridCar.brake(40);
        bike.brake(50);

        System.out.println("\n--- Charging Electric Vehicles ---");
        eCar.chargebattery(50);
        hybridCar.chargebattery(80);

        System.out.println("\n--- Fuel Efficiency Calculation ---");
        System.out.println("Hybrid Car Fuel Efficiency: " + hybridCar.calculatefuelefficiency(500, 20) + " km/l");
    }
}
