package pack1;

import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface1 {
    private static double balance = 1000.00; // Initial balance
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;

        System.out.println("Welcome to the ATM!");

        while (!quit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    showThistory();
                    break;
                case 2:
                    withdrawAmount(sc);
                    break;
                case 3:
                    depositAmount(sc);
                    break;
                case 4:
                    transferAmount(sc);
                    break;
                case 5:
                    quit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. \nPlease try again.");
            }
        }

        sc.close();
    }

    private static void showThistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions to display.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    private static void withdrawAmount(Scanner sc) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= 0) 
        {
            System.out.println("Invalid amount. Please enter a positive value.");
        } 
        else if (amount > balance)
        {
            System.out.println("Insufficient balance.");
        } 
        else
        {
            balance -= amount;
            transactionHistory.add("Withdrawn: $" + amount);
            System.out.println("Withdrawal successful. New balance is : $" + balance);
        }
    }

    private static void depositAmount(Scanner sc) {
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
            System.out.println("Deposit successful. New balance: $" + balance);
        }
    }

    private static void transferAmount(Scanner sc) {
        System.out.print("Enter the recipient's account number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Enter the amount to transfer: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactionHistory.add("Transferred Amount: $" + amount + " to account " + accountNumber);
            System.out.println("Transaction successfull. New balance: $" + balance);
        }
    }
}
