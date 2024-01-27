package org.pjwstk.s27149bank.Storage;

import org.springframework.stereotype.Component;
import org.pjwstk.s27149bank.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerStorage {
    private List<Customer> data = new ArrayList<>();
    private int lastId;
    public void add(Customer customer) {
        this.data.add(customer);
    }
    public List<Customer> getCustomers() { return data;}
    public void clearStorage() {
        data.clear();
    }
    public Optional<Customer> findCustomer(int id) {
        List<Customer> customers = getCustomers();
        return customers.stream().filter(e -> e.getId() == id).findFirst();
    }

    public int getLastId() {
        List<Customer> customers = getCustomers();
        if (customers.isEmpty()) {
            return -1;
        }
        return customers.get(customers.size()-1).getId();
    }
}
