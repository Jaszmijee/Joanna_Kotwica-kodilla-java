package com.kodilla.kodilla.hibernate.invoice.dao;

import com.kodilla.kodilla.hibernate.invoice.Invoice;
import com.kodilla.kodilla.hibernate.invoice.Item;
import com.kodilla.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("product1");
        Product product2 = new Product("product2");

        Item item1 = new Item(new BigDecimal(200), 5, new BigDecimal(1000));
        Item item2 = new Item(new BigDecimal(250), 3, new BigDecimal(750));

        item1.setProduct(product1);
        item2.setProduct(product2);

        Invoice invoice = new Invoice("12345");
        invoice.setItems(Arrays.asList(item1, item2));
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        assertNotEquals(0, invoiceId);

        //CleanUp
        invoiceDao.deleteById(invoiceId);

    }
}


