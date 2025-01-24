import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Display student information
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}

public class StudentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize an array of students
        Student[] students = {
            new Student("Alice", 20, "A"),
            new Student("Bob", 22, "B"),
            new Student("Charlie", 19, "C")
        };

        // Display initial list of students
        System.out.println("Initial list of students:");
        for (Student student : students) {
            student.display();
        }

        // Get the name of the student to update
        System.out.println("\nEnter the name of the student to update:");
        String nameToUpdate = scanner.nextLine();

        // Update the student details
        boolean updated = updateStudentByName(students, nameToUpdate, scanner);

        // Display updated list of students
        if (updated) {
            System.out.println("\nUpdated list of students:");
            for (Student student : students) {
                student.display();
            }
        } else {
            System.out.println("Student with name \"" + nameToUpdate + "\" not found.");
        }

        scanner.close();
    }

    public static boolean updateStudentByName(Student[] students, String name, Scanner scanner) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student found. Enter new details:");

                System.out.print("Enter new name: ");
                student.setName(scanner.nextLine());

                System.out.print("Enter new age: ");
                student.setAge(scanner.nextInt());
                scanner.nextLine(); // Consume the newline character

                System.out.print("Enter new grade: ");
                student.setGrade(scanner.nextLine());

                System.out.println("Student details updated successfully.");
                return true;
            }
        }
        return false; // Student not found
    }
}

