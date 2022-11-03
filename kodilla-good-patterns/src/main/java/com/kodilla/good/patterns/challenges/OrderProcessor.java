package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private InformationService informationService;
    private OrdersRepository ordersRepository;
    private ProductOrderService productOrderService;

    public OrderProcessor(InformationService informationService, OrdersRepository ordersRepository, ProductOrderService productOrderService) {
        this.informationService = informationService;
        this.ordersRepository = ordersRepository;
        this.productOrderService = productOrderService;
    }

    public OrderDTO process(final User user, final Order order) {
        boolean ordered = productOrderService.order(user, order);
        if (ordered) {
            informationService.sendInfo();
            ordersRepository.addOrder(order);
            return new OrderDTO(user, true);
        } else {
            return new OrderDTO(user, false);
        }
    }
}
