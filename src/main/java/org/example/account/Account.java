package org.example.account;

import lombok.Getter;
import lombok.ToString;
import org.example.bank.Bank;

@Getter
@ToString
public class Account {
    private String accountNumber;
    private String accountOwnerName;
    private double balance;
    private Bank bank;

    public Account(String accountNumber, String accountOwnerName, Bank bank) {
        this.accountNumber = accountNumber;
        this.accountOwnerName = accountOwnerName;
        this.bank = bank;
    }

    public void deposit(double amount) {
        if(amount > 0){
            balance+=amount;
            System.out.println("deposit successful!, the current balance is " + balance);
            return;
        }
        System.out.println("invalid deposit amount");
    }

    public void withdraw(double amount) {
        if(balance >= amount) {
            balance-=amount;
            System.out.println("withdraw successful!, the current balance is " + balance);
            return;
        }
        System.out.println("invalid withdraw amount");
    }

}
