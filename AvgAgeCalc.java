import java.util.Scanner;

class Student {
    int age;

    public Student(int age) {
        this.age = age;
    }
}

public class AvgAgeCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            int age = scanner.nextInt();
            students[i] = new Student(age);
        }

        int totalAge = 0;
        for (Student student : students) {
            totalAge += student.age;
        }

        double averageAge = (double) totalAge / numStudents;

        System.out.printf("The average age of students is: ", averageAge);

        scanner.close();
    }
}

