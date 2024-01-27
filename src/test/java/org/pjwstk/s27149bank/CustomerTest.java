package org.pjwstk.s27149bank;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
class CustomerTest {

    @Test
    void getId() {
        Customer customer = new Customer(0, 100.00);
        int id = customer.getId();
        assertThat(id == 0);
    }

    @Test
    void getBalance() {
        Customer customer = new Customer(0, 100.00);
        double balance = customer.getBalance();
        assertThat(balance == 100.00);
    }

    @Test
    void setBalance() {
        Customer customer = new Customer(0, 100.00);
        customer.setBalance(500.00);
        double balance = customer.getBalance();
        assertThat(balance == 500.00);
    }

    @Test
    void setBalanceFail() {
        Customer customer = new Customer(0, 100.00);
        customer.setBalance(500.00);
        double balance = customer.getBalance();
        assertThat(!(balance == 100.00));
    }

    @Test
    void addTransaction() {
        Customer customer = new Customer(0, 100.00);
        Transaction transaction = new Transaction(TransactionStatus.ACCEPTED, 100);
        customer.addTransaction(transaction);
        assertThat(customer.getTransactionHistory().stream().filter(e -> e.equals(transaction)).findFirst() == Optional.of(transaction));
    }
}