package com.kodilla.good.patterns.food2door;

abstract class FoodProducer {

    protected final String producerName;
    protected final int orderingNumber;
    protected final int quantity;

    public FoodProducer(final String producerName, final int orderingNumber, final int quantity) {
        this.producerName = producerName;
        this.orderingNumber = orderingNumber;
        this.quantity = quantity;
    }

    public abstract boolean process();

    @Override
    public String toString() {
        return producerName + ", " + orderingNumber +
                ", quantity: " + quantity;
    }
}
