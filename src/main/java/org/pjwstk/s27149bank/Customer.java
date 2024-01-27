package org.pjwstk.s27149bank;

public class Customer {
    private int id;
    private double balance;

    public Customer(int id, double balance) {
        this.id = id;
        this.balance = balance;
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
}
