package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {


    @Test
    void testBasicPizza() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaDelegate();

        //When
        String description = pizzaOrder.getDescription();
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(BigDecimal.valueOf(15), cost);
        assertEquals("Pizza + sauce + mozzarella", description);
    }

    @Test
    void testCheeseVeggies() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaDelegate();
        pizzaOrder = new MoreCheeseDecorator(pizzaOrder);
        pizzaOrder = new MoreVeggiesDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(BigDecimal.valueOf(25), cost);
        assertEquals("Pizza + sauce + mozzarella + more cheese + vege ingredient", description);
    }

    @Test
    void testCheeseVeggiesVeggiesHotFast() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaDelegate();
        pizzaOrder = new MoreCheeseDecorator(pizzaOrder);
        pizzaOrder = new MoreVeggiesDecorator(pizzaOrder);
        pizzaOrder = new MoreVeggiesDecorator(pizzaOrder);
        pizzaOrder = new ExtraHotPizzaDecorator(pizzaOrder);
        pizzaOrder = new ExpressPizzaDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();
        BigDecimal cost = pizzaOrder.getCost();

        //Then
        assertEquals(BigDecimal.valueOf(43), cost);
        assertEquals("Pizza + sauce + mozzarella + more cheese + vege ingredient " +
                "+ vege ingredient + extra hot + fast delivery", description);
    }
}


