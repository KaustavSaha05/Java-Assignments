public class ExceptionHandlingDemo {
    public static void main(String[] args){
        try{
            int x=10/0;
        }catch(ArithmeticException e){
            System.out.println("ArithmeticException: " + e.getMessage());
        }

        int[] arr = new int[5];
        try{
            System.out.println(arr[10]);
        }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("ArrayIndexOutOfBoundException :" + e.getMessage());
        }

        try{
            Object obj = "Hello";
            Integer num = (Integer)obj;
            System.out.println("Converted number: " + num);
        }catch(ClassCastException e){
            System.out.println("ClassCastException: " + e.getMessage());
        }
        
        try{
            setAge(-5);
        }catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
    }

    public static void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        System.out.println("Age is set to: " + age);
    }
}
