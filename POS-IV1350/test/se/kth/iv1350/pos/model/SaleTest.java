package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.model.Product;
import se.kth.iv1350.pos.model.Sale;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SaleTest {
    private Sale sale;

    @BeforeEach
    void init() { sale = new Sale(); }

    @Test
    void testNewProductAddedToSale() {
        Product firstProduct = new Product(1, 1, "First product", 100, 25);
        Product secondProduct = new Product(2, 1, "Second product", 150, 25);

        sale.addProductToSale(firstProduct);

        assertEquals(1, sale.getCurrentProducts().size());
        assertTrue(sale.isProductInSale(firstProduct));
        assertEquals(100.0, sale.getCustomerPayment().getPaidAmount(100.0));

        sale.addProductToSale(firstProduct);

        assertEquals(1, sale.getCurrentProducts().size());
        assertTrue(sale.isProductInSale(firstProduct));
        assertEquals(2, sale.getCurrentProducts().get(0).getProductQuantity());
        assertEquals(200.0, sale.getCustomerPayment().getPaidAmount(200.0));

        sale.addProductToSale(secondProduct);

        assertEquals(2, sale.getCurrentProducts().size());
        assertTrue(sale.isProductInSale(firstProduct));
        assertTrue(sale.isProductInSale(secondProduct));
        assertEquals(300.0, sale.getCustomerPayment().getPaidAmount(300.0));
    }

    @Test
    void updateSystems() {
        Sale sale = new Sale();
        Sale saleUpdate = new Sale();
        // Test that method does not throw an exception
        assertDoesNotThrow(() -> sale.updateSystems(saleUpdate));
    }
}
