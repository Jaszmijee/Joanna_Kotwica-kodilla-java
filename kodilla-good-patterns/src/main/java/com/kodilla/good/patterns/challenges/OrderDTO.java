package com.kodilla.good.patterns.challenges;

public class OrderDTO {

    private final User user;
    private final boolean isRented;

    public OrderDTO(final User user, final boolean isRented) {
        this.user = user;
        this.isRented = isRented;
    }

    @Override public String toString(){
        return "the order processing for: " + user.getUserName() + ((isRented) ? " has been completed." : " has failed");
    }
}