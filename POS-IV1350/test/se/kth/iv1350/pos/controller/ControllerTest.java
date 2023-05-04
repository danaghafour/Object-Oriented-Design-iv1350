package se.kth.iv1350.pos.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.integration.ReceiptPrinter;
import se.kth.iv1350.pos.model.ProductDTO;
import se.kth.iv1350.pos.model.SaleDTO;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.Product;

class ControllerTest {
    private Controller controllerTest;
    private AccountingSystem accountingS;
    private InventorySystem inventoryS;

    private Sale saleCont;
    private ReceiptPrinter receiptPrinter;

    @BeforeEach
    void init() {
        accountingS = new AccountingSystem();
        inventoryS = new InventorySystem();
        receiptPrinter = new ReceiptPrinter();
        controllerTest = new Controller(accountingS, inventoryS, receiptPrinter);
    }

    @AfterEach
    private void resetCont(){
        saleCont = null;
        controllerTest = null;
        inventoryS = null;
        accountingS = null;
    }

    @Test
    void testEndSale() {
        boolean isNull;
        controllerTest.endSale();
        Sale notNullSale = controllerTest.getSaleCont();
        if(notNullSale != null) {
            isNull = false;
        } else isNull = true;
        assertTrue(isNull);
        }

    @Test
    void testScanProduct() {
        controllerTest.startSale();
        int productId = 44;
        boolean productAdded = false;

        controllerTest.scanProduct(productId);
        Product product = new Product(inventoryS.getProductDTOFromDB(productId));
        if(controllerTest.getSaleCont().isProductInSale(product))
            productAdded = true;
        assertEquals(productAdded, true);

    }

    @Test
    void testPaySale() {
        controllerTest.startSale();
        int productId = 44;
        controllerTest.scanProduct(productId);
        double expectedChange = 0;
        double amountPaid = controllerTest.paySale(500);
        assertEquals(expectedChange, amountPaid);
    }

}