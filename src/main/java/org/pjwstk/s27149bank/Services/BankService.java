package org.pjwstk.s27149bank.Services;

import org.pjwstk.s27149bank.Customer;
import org.pjwstk.s27149bank.Storage.CustomerStorage;
import org.springframework.stereotype.Service;

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


}
