import java.util.Scanner;

// Account Class (Encapsulation)
class Account {
    private double balance = 5000; // initial balance

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } 
        else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } 
        else {
            balance -= amount;
            System.out.println("Withdraw successful!");
        }
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }
}

// ATM Class
class ATM {
    static int PIN = 1234;

    // Method for authentication
    public boolean authenticate(int userPin) {
        return userPin == PIN;
    }
}

// Main Class
public class ATMSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();
        Account acc = new Account();

        try {
            // Step 1: PIN Authentication
            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (!atm.authenticate(enteredPin)) {
                System.out.println("Incorrect PIN! Access Denied.");
                return;
            }

            // Step 2: Menu
            int choice;
            do {
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Withdraw Money");
                System.out.println("2. Check Balance");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();
                        acc.withdraw(amount);
                        break;

                    case 2:
                        System.out.println("Balance: " + acc.getBalance());
                        break;

                    case 3:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 3);

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter numbers only.");
        }

        sc.close();
    }
}