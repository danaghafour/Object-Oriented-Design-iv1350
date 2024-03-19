package exceptions;
import org.junit.jupiter.api.*;
import se.kth.iv1350.pos.integration.InventorySystem;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryDBExceptionTest {
    private InventorySystem inventorySystem = InventorySystem.getInventorySystemInstance();

    @AfterEach
    void cleanup(){
        inventorySystem = InventorySystem.getInventorySystemInstance();
    }

    @Test
    void testInventoryDataShouldThrowServerDownException(){
        int productIdDown = 404;
        RuntimeException serverDownProductId = assertThrows(RuntimeException.class, () -> inventorySystem.getProductDTOFromDB(productIdDown));

        assertEquals(serverDownProductId.getMessage(),"The inventory system server is currently unavailable.", "The exception message should match the expected message when the inventory server is down.");
    }

    @Test
    void testInventoryDataShouldNotThrowServerDownException(){
        int productIDNotDown = 44;

        RuntimeException serverDownItemID = assertThrows(RuntimeException.class, () -> inventorySystem.getProductDTOFromDB(productIDNotDown));

        assertNotEquals(serverDownItemID.getMessage(),"The inventory system server is currently unavailable.");
    }

}
