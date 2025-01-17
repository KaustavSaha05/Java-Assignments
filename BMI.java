import java.util.Scanner;

public class BMI {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter choice: \n");
        System.out.print("1. Weight in pounds and height in inches\n");
        System.out.print("2. Weight in kilograms and height in meters\n");

        int choice = scanner.nextInt();

        if(choice == 1){
            System.out.print("Enter weight in pounds: ");
            double weight = scanner.nextDouble();

            System.out.print("Enter height in inches: ");
            double height = scanner.nextDouble();

            double bmi = (weight * 703)/(height * height);

            System.out.print("BMI is " + bmi);
        }

        else if(choice == 2){
            System.out.print("Enter weight in Kilograms: ");
            int weight = scanner.nextInt();

            System.out.print("Enter height in meters: ");
            int height = scanner.nextInt();
            
            double bmi = (weight)/(height * height);

            System.out.print("BMI is " + bmi);
        }
        scanner.close();
    }
}
