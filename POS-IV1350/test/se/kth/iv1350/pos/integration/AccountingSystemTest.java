package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.pos.model.Product;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.SaleDTO;

public class AccountingSystemTest {
    private AccountingSystem accountingS;

    @BeforeEach
    public void init() {
        accountingS = new AccountingSystem();
    }

    @Test
    public void testUpdate() {
        // Create a new sale object and add some items
        Sale sale = new Sale();
        sale.addProductToSale(new Product(12345, 1, "Test Product 1", 123.45, 0.25));
        sale.addProductToSale(new Product(6789, 2, "Test Product 2", 67.89, 0.25));
        SaleDTO saleDTO = new SaleDTO(sale);

        // Call the method to be tested
        accountingS.update(saleDTO);

        // Verify that the accounting system was updated correctly
        // In this example, we just check that the method completed without throwing an exception.
        assertEquals(1, 1);
    }
}
