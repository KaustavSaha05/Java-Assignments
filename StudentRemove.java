import java.util.Scanner;

public class StudentRemove {
    public static void main(String[] args) {
        // Example array of student names
        String[] students = {"Alice", "Bob", "Charlie", "David", "Eve"};
        try (Scanner scanner = new Scanner(System.in)) {

        System.out.println("Current students: ");
        displayArray(students);

        System.out.print("\nEnter the name of the student to remove: ");
        String nameToRemove = scanner.nextLine();

        String[] updatedStudents = removeStudentByName(students, nameToRemove);

        System.out.println("\nUpdated students: ");
        displayArray(updatedStudents);
        }
    }

    // Method to remove a student by name
    public static String[] removeStudentByName(String[] students, String name) {
        int indexToRemove = -1;

        // Find the index of the student to remove
        for (int i = 0; i < students.length; i++) {
            if (students[i].equalsIgnoreCase(name)) {
                indexToRemove = i;
                break;
            }
        }

        // If student not found, return the original array
        if (indexToRemove == -1) {
            System.out.println("\nStudent with name \"" + name + "\" not found!");
            return students;
        }

        // Create a new array with one less element
        String[] updatedArray = new String[students.length - 1];

        // Copy all elements except the one to remove
        int j = 0;
        for (int i = 0; i < students.length; i++) {
            if (i != indexToRemove) {
                updatedArray[j++] = students[i];
            }
        }

        System.out.println("\nStudent \"" + name + "\" removed successfully!");
        return updatedArray;
    }

    // Method to display the array
    public static void displayArray(String[] array) {
        for (String item : array) {
            System.out.println(item);
        }
    }
}
