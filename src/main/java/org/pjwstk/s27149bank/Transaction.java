package org.pjwstk.s27149bank;

public class Transaction {
    private TransactionStatus status;
    private double balance;
    private String error;

    public Transaction(TransactionStatus status, double balance) {
        this.status = status;
        this.balance = balance;
    }

    public Transaction(TransactionStatus status, String error) {
        this.status = status;
        this.error = error;
    }
    public TransactionStatus getStatus() {
        return status;
    }

    public double getBalance() {
        return balance;
    }
}
