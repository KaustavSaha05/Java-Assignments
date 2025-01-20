import  java.util.Scanner;

class Student {
	int age;
	
	public Student(int age){
		this.age = age;
	}
	
	public int getage(){
		return age;
	}
}

public class AvgAgeCalc {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter no.of students: ");
		int numberofstudents = scanner.nextInt();
		
		Student[] students = new Student[numberofstudents];
		int totalage = 0;
		
		for(int i=0; i<numberofstudents;i++){
			System.out.print("Enter:");
			int age = scanner.nextInt();
			
			students[i] = new Student(age);
			totalage += students[i].getage();
		}
		double AvgAge = (double)totalage/numberofstudents;
		System.out.print("The avg age is: " + AvgAge);
		
		scanner.close();
	}


}
