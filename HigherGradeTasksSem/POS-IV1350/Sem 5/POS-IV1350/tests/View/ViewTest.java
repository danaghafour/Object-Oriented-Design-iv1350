package View;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.view.View;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.integration.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest {

    private final PrintStream originalSystemOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalSystemOut);
    }

    @Test
    void testShowProductsInSale() {
        AccountingSystem accountingSystem = AccountingSystem.getAccountingSystemInstance();
        InventorySystem inventorySystem = InventorySystem.getInventorySystemInstance();
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        Controller controller = new Controller(accountingSystem, inventorySystem, receiptPrinter);
        View view = new View(controller);
        Sale sale = new Sale();
        SaleDTO saleDTO = new SaleDTO(sale);
        ProductDTO product1 = new ProductDTO(1, 10.0, 0.1, 1, "Product 1");
        ProductDTO product2 = new ProductDTO(2, 20.0, 0.2, 2, "Product 2");
        saleDTO.getCurrentProducts().add(product1);
        saleDTO.getCurrentProducts().add(product2);
        view.showProductsInSale(saleDTO);
        String expectedOutput = "Products in sale:\n" +
                "Product 1\n" +
                "Product 2\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
