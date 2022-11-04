package com.kodilla.good.patterns.food2door;

public class HealthyShop extends FoodProducer {

    private final User user;

    public HealthyShop(final User user, final int orderingNumber, final int quantity) {
        super("HealthyShop", orderingNumber, quantity);
        this.user = user;
    }

    public boolean process() {
        //TODO Implement InformationService
        if (this.user == null) {
            System.out.println("Ask for registration");
            return false;
        }

        System.out.println("send confirmation by e-mail");
        System.out.println("get payment upon delivery");
        return true;
    }
}

