package ru.otus;

import java.util.*;

public class CustomerReverseOrder {

//    private Deque<Customer> customers = new ArrayDeque<>();
    private Stack<Customer> customers = new Stack<>();

    public void add(Customer customer1) {
        customers.add(customer1);
    }

    public Customer take() {
        return customers.pop();
    }
}
