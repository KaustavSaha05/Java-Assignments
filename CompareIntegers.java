import java.util.Scanner; 
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		int firstnum = scanner.nextInt();

		System.out.print("Enter second integer: ");
		int secondnum = scanner.nextInt();

		if(firstnum > secondnum){
			System.out.print(firstnum + "is larger");
		} else if(secondnum > firstnum){
			System.out.print(secondnum + "is larger");
		} else{
			System.out.print("both numbers are equal");
		}
		scanner.close();

	}