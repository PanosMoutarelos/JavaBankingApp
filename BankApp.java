import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankData bankData = new BankData();

        int NextId=1;

        System.out.println("=== Welcome to the Bank System ===");

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create new account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check balance");
            System.out.println("5. List all accounts");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            // ✅ Always read user choice inside the loop
            int choice;
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // consume newline
            } else {
                System.out.println("Invalid input! Please enter a number.");
                input.nextLine(); // clear invalid input
                continue; // restart menu
            }

            switch (choice) {
                case 1:
                    // --- Create new account ---
                    String name;
                    while (true) {
                        System.out.print("Enter account holder name: ");
                        name = input.nextLine();
                        if (name.matches("[a-zA-Z ]+")) break;
                        System.out.println("Invalid name. Please use letters only!");
                    }

                    double balance;
                    while (true) {
                        System.out.print("Enter initial balance: ");
                        if (input.hasNextDouble()) {
                            balance = input.nextDouble();
                            input.nextLine(); // consume leftover newline
                            if (balance >= 0) break;
                            System.out.println("Balance cannot be negative!");
                        } else {
                            System.out.println("Invalid input! Please enter a number.");
                            input.nextLine();
                        }
                    }

                    // Assign unique ID using NextId
                    BankAccount newAccount = new BankAccount(NextId++, name, balance);
                    bankData.addAccount(newAccount);

                    System.out.println("✅ Account created successfully! Account ID: " + newAccount.getId());
                    break;

                case 2:
                    // --- Deposit ---
                    System.out.print("Enter account holder name: ");
                    String depositName = input.nextLine();
                    BankAccount accDeposit = bankData.findAccount(depositName);
                    if (accDeposit != null) {
                        System.out.print("Enter deposit amount: ");
                        if (input.hasNextDouble()) {
                            double depositAmount = input.nextDouble();
                            input.nextLine();
                            accDeposit.deposit(depositAmount);
                        } else {
                            System.out.println("Invalid amount!");
                            input.nextLine();
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    // --- Withdraw ---
                    System.out.print("Enter account holder name: ");
                    String withdrawName = input.nextLine();
                    BankAccount accWithdraw = bankData.findAccount(withdrawName);
                    if (accWithdraw != null) {
                        System.out.print("Enter withdrawal amount: ");
                        if (input.hasNextDouble()) {
                            double withdrawAmount = input.nextDouble();
                            input.nextLine();
                            accWithdraw.withdraw(withdrawAmount);
                        } else {
                            System.out.println("Invalid amount!");
                            input.nextLine();
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    // --- Check Balance ---
                    System.out.print("Enter account holder name: ");
                    String checkName = input.nextLine();
                    BankAccount accCheck = bankData.findAccount(checkName);
                    if (accCheck != null) {
                        accCheck.displayBalance();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    // --- List all accounts ---
                    bankData.listAccounts();
                    break;

                case 6:
                    // --- Exit ---
                    System.out.println("👋 Exiting... Goodbye!");
                    input.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
