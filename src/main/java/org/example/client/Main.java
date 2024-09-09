package org.example.client;

import org.example.account.Account;
import org.example.bank.Bank;
import org.example.bank.BankAlahly;
import org.example.bank.BankMisr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println("choose what you want: ");
            System.out.println("1. creating Account");
            System.out.println("2. Access Existing Account");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    accessAccount(scanner);
                    break;
                case 3:
                    exit=true;
                    System.out.println("Thank you for using the bank system!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        }



    }

    private static void createAccount(Scanner scanner) {
        scanner.nextLine();

        System.out.println("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter your name: ");
        String accountOwnerName = scanner.nextLine();

        System.out.println("choose bank name: ");
        System.out.println("1. Bank Misr");
        System.out.println("2. Bank Al Ahly");
        int choice = scanner.nextInt();

        Bank bank = null;
        if(choice == 1){
            bank = new BankMisr();
        }else if(choice == 2) {
            bank = new BankAlahly();
        }else {
            System.out.println("invalid choice");
        }

        Account account = new Account(accountNumber, accountOwnerName, bank);
        accounts.add(account);
    }

    private static void accessAccount(Scanner scanner) {
        scanner.nextLine();

        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account currentAccount = findAccount(accountNumber);

        if(currentAccount == null) {
            System.out.println("Account Not found!");
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("choose what you want :");
            System.out.println("1. View Account Information");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println(currentAccount);
                    break;
                case 2:
                    System.out.println("Enter Deposit Amount: ");
                    double depositAmount = scanner.nextDouble();
                    currentAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter withdraw Amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    currentAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("invalid choice");
                    break;
            }
        }


    }

    private static Account findAccount(String accountNumber) {
        List<Account> accounts2 = accounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .collect(Collectors.toList());

        if(accounts2.size() > 0){
            return accounts2.get(0);
        }
        return null;
    }
}