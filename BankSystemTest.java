class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}

class BankAccount {
    private String accnumber;
    private String accholder;
    private double balance;

    public BankAccount(String accnumber, String accholder, double balance){
        this.accnumber = accnumber;
        this.accholder = accholder;
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Deposit amount can't be negative");
        }
        balance += amount;
        System.out.println("Deposited: $" + amount + " New balance: $" + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount>balance){
            throw new InsufficientFundsException("Insufficient funds!");
        }
        balance -= amount;
        System.out.println("Withdrawn: $" + amount + " Remaining balance: $" + balance);
    }

    public void displayaccount(){
        System.out.println("Account Number: " + accnumber);
        System.out.println("Account Holder: " + accholder);
        System.out.println("Balance: $" + balance);
    }
}

public class BankSystemTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", "Kaustav Saha", 1000.0);

        account.displayaccount();
        
        try {
            account.deposit(500.0);
            account.deposit(-100.0); 
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            account.withdraw(300.0);
            account.withdraw(1500.0); 
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
