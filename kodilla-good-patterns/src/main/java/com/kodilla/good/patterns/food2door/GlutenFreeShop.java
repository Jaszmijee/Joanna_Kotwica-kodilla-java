package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop extends FoodProducer {

    private final boolean hasACat;

    public GlutenFreeShop(int orderingNumber, int quantity, boolean hasACat) {
        super("GlutenFreeShop", orderingNumber, quantity);
        this.hasACat = hasACat;
    }

    public boolean process() {
        if (!hasACat) {
            return false;
        } else {
            //TODO Implement InformationService
            System.out.println("Send greetings for a cat by SMS");
            System.out.println("Send picture of your cat by MMS");
            System.out.println("Collect payment after delivery");
            return true;
        }
    }
}
