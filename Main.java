import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Create TreeSet
        TreeSet<Integer> studentIDs = new TreeSet<>();

        // Add elements
        studentIDs.add(103);
        studentIDs.add(101);
        studentIDs.add(102);
        studentIDs.add(104);

        // Display sorted student IDs
        System.out.println("Sorted Student IDs:");
        studentIDs.forEach(id -> System.out.println(id));
    }
} 
