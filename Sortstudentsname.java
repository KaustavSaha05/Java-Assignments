import java.util.*;

class Student {
    String name;

    // Constructor
    public Student(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Sortstudentsname {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student("John"));
        students.add(new Student("Alice"));
        students.add(new Student("Bob"));
        students.add(new Student("Charlie"));

        // Printing students before sorting
        System.out.println("Before sorting:");
        for (Student student : students) {
            System.out.println(student);
        }

        students.sort(Comparator.comparing(student -> student.name));

        // Printing students after sorting
        System.out.println("\nAfter sorting:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
