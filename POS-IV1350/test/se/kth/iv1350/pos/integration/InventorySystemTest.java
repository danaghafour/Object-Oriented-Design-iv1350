package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.model.Product;
import se.kth.iv1350.pos.model.ProductDTO;
import se.kth.iv1350.pos.model.SaleDTO;

class InventorySystemTest {

    private Product[] productsInDB;
    private InventorySystem inventorySys = new InventorySystem();

    @BeforeEach
    void init() {
        inventorySys = new InventorySystem();
    }

    @Test
    void testUpdateSaleQuantity() {
    }

    @Test
    void testItemDTORetrievedFromDb () {
        ProductDTO productDTONotNull;
        boolean productFound;

        productDTONotNull = inventorySys.getProductDTOFromDB(44);
        if(productDTONotNull != null) {
            productFound = true;
        }
        else productFound = false;
        assertEquals(true, productFound);
        }
    }
