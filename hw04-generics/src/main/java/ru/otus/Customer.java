package ru.otus;

import java.util.Objects;

public class Customer implements Cloneable {

    private long customerId;
    private String name;
    private long scores;

    public Customer(long customerId, String name, long scores) {
        this.customerId = customerId;
        this.name = name;
        this.scores = scores;
    }

    public Customer() {
        this.customerId = -1;
        this.scores = Long.MAX_VALUE;
        this.name = "";
    }

    public void setName(String expectedName) {
        this.name = expectedName;
    }

    public String getName() {
        return name;
    }

    public long getScores() {
        return scores;
    }

    public void setScores(long newScoreSecond) {
        this.scores = newScoreSecond;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public Customer clone() {
        return new Customer(customerId, name, scores);
    }

    public long getId() {
        return customerId;
    }
}
