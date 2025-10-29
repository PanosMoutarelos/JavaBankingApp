import java.util.ArrayList;

public class BankData {

    private ArrayList<BankAccount> accounts;



    public BankData() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccount(String name) {
        for (BankAccount account : accounts) {
            if (account.getAccountHolder().equalsIgnoreCase(name)) {
                return account;
            }
        }
        return null; // not found
    }

    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (BankAccount account : accounts) {
                account.displayBalance();
                System.out.println("------------------");
            }
        }
    }
}

