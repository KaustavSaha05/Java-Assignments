class MyStudent {
    String name;
    int age;

    public MyStudent() {
        this.name = "Unknown";
        this.age = 18;
    }

    public MyStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class DefaultConstructor {
    public static void main(String[] args) {

        MyStudent student1 = new MyStudent();
        student1.display(); 
    

        MyStudent student2 = new MyStudent("Alice", 22);
        student2.display(); 
    }
}
    
