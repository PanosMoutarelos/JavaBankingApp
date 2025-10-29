public class BankAccount {
    private int id;
    private String accountHolder;
    private double balance;

    public BankAccount(int id, String accountHolder, double balance) {
        this.id = id;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited " + amount + " from " + accountHolder);
            System.out.println("New balance is " + balance);
        }
        else {
            System.out.println("Deposit amount must be positive");
        }
    }
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        }
        else if(amount > balance){
            System.out.println("Insufficient Balance");
        }
        else{
            System.out.println("Withdrawal amount must be positive");
        }
    }
    public void displayBalance(){
        System.out.println("Account holder: " + accountHolder);
        System.out.println("Current Balance  $" + balance);
    }
    public double getBalance(){
        return balance;
    }
    BankData bankData = new BankData();

}
