package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacComposition() {
        // Given
        Bigmac bigmac = new Bigmac.BigMacBuilder()
                .setBun("No sesame")
                .setSauce("1000 Islands")
                .setIngredient("Onion")
                .build();
        System.out.println(bigmac);

        //When && Then
        assertEquals(1, bigmac.getIngredients().size());
        assertEquals("1000 Islands", bigmac.getSauce());
        assertFalse(bigmac.getIngredients().contains("Prawns"));
        assertTrue(bigmac.toString().contains("burgers=0"));
    }

    @Test
    void testBigmacNegativeBurgers() {

        Bigmac bigmac = new Bigmac.BigMacBuilder()
                .setBun("No sesame")
                .setBurgers(-1)
                .setSauce("Barbecue")
                .setIngredient("Lettuce")
                .setIngredient("Onion")
                .setIngredient("Bacon")
                .setIngredient("Cheese")
                .build();
        System.out.println(bigmac);

        //When && Then
        assertNull(bigmac);

    }
}

