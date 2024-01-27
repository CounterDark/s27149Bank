package org.pjwstk.s27149bank.Services;

import org.pjwstk.s27149bank.Customer;
import org.pjwstk.s27149bank.Storage.CustomerStorage;
import org.pjwstk.s27149bank.Transaction;
import org.pjwstk.s27149bank.TransactionStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {
    private CustomerStorage customerStorage;

    public BankService(CustomerStorage customerStorage) {
        this.customerStorage = customerStorage;
    }

    public Customer registerCustomer(double balance) {
        int customerId = this.customerStorage.getLastId()+1;
        Customer customer = new Customer(customerId, balance);
        this.customerStorage.add(customer);
        return customer;
    }

    public Transaction transfer(int id, double amount) {
        Optional<Customer> customer = this.customerStorage.findCustomer(id);
        if (customer.isEmpty()) {
            return missingCustomerStatus();
        }
        double currentBalance = customer.get().getBalance();
        if (currentBalance < amount) {
            return insufficientFundsStatus(customer.get().getBalance());
        }
        customer.get().setBalance(currentBalance-amount);
        Transaction transaction = new Transaction(TransactionStatus.ACCEPTED, customer.get().getBalance());
        customer.get().addTransaction(transaction);
        return transaction;
    }

    public Transaction payment(int id, double amount) {
        Optional<Customer> customer = this.customerStorage.findCustomer(id);
        if (customer.isEmpty()) {
            return missingCustomerStatus();
        }
        double currentBalance = customer.get().getBalance();
        customer.get().setBalance(currentBalance+amount);
        Transaction transaction = new Transaction(TransactionStatus.ACCEPTED, customer.get().getBalance());
        customer.get().addTransaction(transaction);
        return transaction;
    }

    private Transaction missingCustomerStatus() {
        return new Transaction(TransactionStatus.DECLINED, "Klient nie jest zarejestrowany!");
    }

    private Transaction insufficientFundsStatus(double currentBalance) {
        return new Transaction(TransactionStatus.DECLINED, currentBalance, "Brak środków!");
    }
}
