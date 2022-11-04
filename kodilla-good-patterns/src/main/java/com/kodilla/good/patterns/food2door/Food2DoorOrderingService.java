package com.kodilla.good.patterns.food2door;

public class Food2DoorOrderingService {

    private FoodProducer foodProducer;

    public FoodProducerDTO processOrder(FoodProducer foodProducer) {
        return (foodProducer.process()) ? new FoodProducerDTO(foodProducer, true)
                : new FoodProducerDTO(foodProducer, false);
    }
}

