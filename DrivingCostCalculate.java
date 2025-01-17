import java.util.Scanner;

public class DrivingCostCalculate {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total miles driven per day: ");
        double miles = scanner.nextDouble();

        System.out.print("Enter cost per gallon of gasoline: ");
        int cost = scanner.nextInt();

        System.out.print("Enter average miles per gallon: ");
        double mpg = scanner.nextDouble();

        System.out.print("Enter parking fees per day: ");
        int parking = scanner.nextInt();

        System.out.print("Enter tolls per day: ");
        int tolls = scanner.nextInt();

        double fuelcost = (miles/mpg) * cost;
        double totalcost = fuelcost + parking + tolls;

        System.out.print("The user's per day driving cost is " + totalcost);

        scanner.close();
    }
}
