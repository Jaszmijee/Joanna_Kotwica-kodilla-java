package com.kodilla.good.patterns.food2door;

public class FoodProducerDTO {

    private final FoodProducer foodProducer;
    private final boolean isOrdered;

    public FoodProducerDTO(FoodProducer foodProducer, boolean isOrdered) {
        this.foodProducer = foodProducer;
        this.isOrdered = isOrdered;
    }

    @Override
    public String toString() {
        return (isOrdered) ? foodProducer.toString() + " order completed"
                : foodProducer.toString() + " order failed";
    }
}
