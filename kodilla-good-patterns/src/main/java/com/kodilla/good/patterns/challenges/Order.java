package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class Order {

    private User user;
    private LocalDate orderDate;
    private Item item;
    private int amount;

    public Order(User user, int year, int month, int day, Item item, int amount) {
        this.user = user;
        this.orderDate = LocalDate.of(year, month, day);
        this.item = item;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        if (!user.equals(order.user)) return false;
        return orderDate.equals(order.orderDate);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + orderDate.hashCode();
        return result;
    }
}
