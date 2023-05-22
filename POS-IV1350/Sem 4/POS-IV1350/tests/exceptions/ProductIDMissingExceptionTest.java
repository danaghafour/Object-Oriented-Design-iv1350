package exceptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.integration.InventorySystem;

import static org.junit.jupiter.api.Assertions.*;

class ProductIDMissingExceptionTest extends Exception{

    private InventorySystem inventorySystem = InventorySystem.getInventorySystemInstance();

    @AfterEach
    public void cleanup()
    {
        inventorySystem = InventorySystem.getInventorySystemInstance();
    }

    @Test
    void testGetProductIDShouldThrowException()
    {
        int falseProductID = 12;

        RuntimeException productIDMissingException = assertThrows(RuntimeException.class, () -> inventorySystem.getProductDTOFromDB(falseProductID));

        assertEquals(productIDMissingException.getMessage(),"Product with ID " + falseProductID + " not found in external inventory system.", "The exception message should match the expected message when a product ID is missing.");
    }


    @Test
    void testGetItemIDShouldNotThrowException()
    {
        int realProductID = 121;

        assertDoesNotThrow(() -> inventorySystem.getProductDTOFromDB(realProductID));
    }
}