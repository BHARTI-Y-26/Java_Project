 // Final ATM Project Code

import java.util.Scanner;

// Abstract Class (Abstraction)
abstract class BankAccount {
    protected double balance;

    // Constructor
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Abstract Method
    public abstract void withdraw(double amount);

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited Successfully!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    // Check Balance
    public void checkBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }
}

// Savings Account Class (Inheritance)
class SavingsAccount extends BankAccount {

    public SavingsAccount(double balance) {
        super(balance);
    }

    // Method Overriding (Polymorphism)
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount!");
        } 
        else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } 
        else {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
        }
    }
}

// ATM Class (Encapsulation)
class ATM {
    private int pin;

    // Constructor
    public ATM(int pin) {
        this.pin = pin;
    }

    // Authentication
    public boolean authenticate(int enteredPin) {
        return pin == enteredPin;
    }

    // Change PIN
    public void changePin(int newPin) {
        pin = newPin;
        System.out.println("PIN Changed Successfully!");
    }
}

// Main Class
public class ATMSimulation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ATM atm = new ATM(1234);

        // Runtime Polymorphism
        BankAccount account = new SavingsAccount(5000);

        try {
            System.out.print("Enter ATM PIN: ");
            int enteredPin = sc.nextInt();

            if (!atm.authenticate(enteredPin)) {
                System.out.println("Incorrect PIN! Access Denied.");
                return;
            }

            int choice;

            do {
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Withdraw Money");
                System.out.println("2. Deposit Money");
                System.out.println("3. Check Balance");
                System.out.println("4. Change PIN");
                System.out.println("5. Exit");
                System.out.print("Enter Choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;

                    case 2:
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 3:
                        account.checkBalance();
                        break;

                    case 4:
                        System.out.print("Enter New PIN: ");
                        int newPin = sc.nextInt();
                        atm.changePin(newPin);
                        break;

                    case 5:
                        System.out.println("Thank You for Using ATM!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 5);

        } catch (Exception e) {
            System.out.println("Invalid Input! Numbers Only.");
        }

        sc.close();
    }
}