package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop extends FoodProducer {

    public ExtraFoodShop(int orderingNumber, int quantity) {
        super("ExtraFoodShop", orderingNumber, quantity);
    }

    //TODO Implement PaymentService
    public boolean paidOnline() {
        return true;
    }

    public boolean process() {
        if (quantity <= 0) {
            throw new RuntimeException("Incorrect number of items");
        }
        if (paidOnline()) {
            //TODO Implement InformationService
            System.out.println("send items to the customer");
            System.out.println("call customer upon delivery arrival");
            return true;
        } else {
            System.out.println("payment failed");
            return false;
        }
    }
}

