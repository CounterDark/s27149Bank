package org.pjwstk.s27149bank.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pjwstk.s27149bank.Customer;
import org.pjwstk.s27149bank.Storage.CustomerStorage;
import org.pjwstk.s27149bank.Transaction;
import org.pjwstk.s27149bank.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
class BankServiceTest {

    private static BankService bankService;
    private static CustomerStorage customerStorage;

    @BeforeEach
    public static void clear(){
        customerStorage.clearStorage();
    }
    @Test
    void registerCustomer() {
        Customer customer = bankService.registerCustomer(100d);
        assertThat(customer.getId() == 0 && customer.getBalance() == 100.00);
    }

    @Test
    void transfer() {
        Customer customer = bankService.registerCustomer(200d);
        Transaction transaction = bankService.transfer(0, 100d);
        assertThat(transaction.getStatus() == TransactionStatus.ACCEPTED && transaction.getBalance() == 100d);
    }

    @Test
    void payment() {
        Customer customer = bankService.registerCustomer(200d);
        Transaction transaction = bankService.payment(0, 100d);
        assertThat(transaction.getStatus() == TransactionStatus.ACCEPTED && transaction.getBalance() == 300d);
    }

    @Test
    void getCustomerInfo() {
        Customer customer = bankService.registerCustomer(200d);
        Customer customer1 = bankService.getCustomerInfo(0);
        assertThat(customer1.equals(customer));
    }
}