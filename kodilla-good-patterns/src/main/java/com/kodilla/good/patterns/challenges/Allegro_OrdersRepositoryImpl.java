package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.Map;

public class Allegro_OrdersRepositoryImpl implements OrdersRepository {

    private Map<String, Order> allegroRepository = new HashMap<>();

    public void addOrder(Order order) {

        this.allegroRepository.put(order.getUser().getUserName() + order.getOrderDate(), order);
    }
}
