package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Product class.
 */
class ProductTest {

    private Product productTest;

    @BeforeEach
    private void createTestProduct() {
        productTest = new Product(120, 1, "Magic Mouse", 100, 25); }

    @AfterEach
    private void cleanUp() {productTest = null;}

    @Test
    void testIncreaseQuantity() {
        int quantityAdded = 1;
        int quantityBefore = productTest.getProductQuantity();
        productTest.increaseQuantity(quantityAdded);
        assertEquals(productTest.getProductQuantity(), quantityAdded + quantityBefore);
    }

}
