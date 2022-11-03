package com.kodilla.good.patterns.challenges;

public class AllegroApplication {
    public static void main(String[] args) {

        User user1 = new User("jaszmije");
        Order order1 = new Order(user1, 2022, 11, 3, new Item(1212), 2);
        OrderProcessor processor = new OrderProcessor(new Email_InformationServiceImpl(),
                new Allegro_OrdersRepositoryImpl(),
                new ProductOrderService());

        System.out.println(processor.process(user1, order1));
    }
}


