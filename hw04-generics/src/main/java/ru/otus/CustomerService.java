package ru.otus;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private Map<Customer, String> customers = new HashMap<>();

    public void add(Customer customer1, String data1) {
        customers.put(customer1, data1);
    }

    public Map.Entry<Customer, String> getSmallest() {

        if (this.customers.isEmpty()) {
            return null;
        }

        Map.Entry<Customer, String> min = Map.entry(new Customer(), "");

        for (Map.Entry<Customer, String> customer : customers.entrySet()) {

            if (customer.getKey().getScores() <= min.getKey().getScores()) {
                min = customer;
            }
        }

        return Map.entry(min.getKey().clone(), min.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer key) {
        long score = key.getScores();

        if (this.customers.isEmpty()) {
            return null;
        }

        Map.Entry<Customer, String> min = Map.entry(new Customer(), "");

        for (Map.Entry<Customer, String> customer : customers.entrySet()) {

            if (customer.getKey().getScores() > score && customer.getKey().getScores() <= min.getKey().getScores()) {
                min = customer;
            }
        }

        if (min.getKey().getScores() == Long.MAX_VALUE) {
            return null;
        }

        return Map.entry(min.getKey().clone(), min.getValue());
    }
}
