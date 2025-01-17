import java.util.Scanner;

public class Multiplescheck {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int firstnum = input.nextInt();

        System.out.print("Enter second number: ");
        int secondnum = input.nextInt();

        if(secondnum != 0){
            if(firstnum % secondnum == 0){
                System.out.print(firstnum + " is divisible by " + secondnum);
            }else{
                System.out.print(firstnum + " is not divisible by " + secondnum);
            }
        }else{
            System.out.print("Division by zero is not allowed");
        }
        input.close();
    }
}
