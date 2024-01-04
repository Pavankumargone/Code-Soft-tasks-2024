package com.codesoft.task3;

import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.printf("Withdrawal successful. Remaining balance: $%.2f%n", userAccount.checkBalance());
                } else {
                    System.out.println("Withdrawal failed.");
                }
                break;

            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                if (userAccount.deposit(depositAmount)) {
                    System.out.printf("Deposit successful. Updated balance: $%.2f%n", userAccount.checkBalance());
                } else {
                    System.out.println("Deposit failed.");
                }
                break;

            case 3:
                System.out.printf("Current balance: $%.2f%n", userAccount.checkBalance());
                break;

            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);

            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    public void runATM() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            try {
                System.out.print("Enter your choice (1-4): ");
                int choice = scanner.nextInt();
                performTransaction(choice);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }
}

