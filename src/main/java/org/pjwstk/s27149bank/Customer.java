package org.pjwstk.s27149bank;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private double balance;

    private List<Transaction> transactionHistory;

    public Customer(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionHistory.add(transaction);
    }

    public List<Transaction> getTransactionHistory() {
        return this.transactionHistory;
    }
}
