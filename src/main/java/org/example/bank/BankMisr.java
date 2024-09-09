package org.example.bank;


public class BankMisr extends Bank{

    public BankMisr() {
    }

    public BankMisr(String bankName) {
        super("Bank Misr");
    }

    @Override
    public String toString() {
        return "BankMisr";
    }
}
