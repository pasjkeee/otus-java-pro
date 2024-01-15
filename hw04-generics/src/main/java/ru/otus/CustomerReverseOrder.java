package ru.otus;

import java.util.*;

public class CustomerReverseOrder {

    private Deque<Customer> customers = new ArrayDeque<>();

    public void add(Customer customer1) {
        customers.addLast(customer1);
    }

    public Customer take() {
        return customers.pollLast();
    }
}
