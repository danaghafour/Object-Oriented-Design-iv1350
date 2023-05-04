package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.model.Product;
import se.kth.iv1350.pos.model.ProductDTO;
import se.kth.iv1350.pos.model.Receipt;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptTest {
    private Receipt receiptTest;
    private Product productTest;

    @BeforeEach
    public void init() {
        receiptTest = new Receipt();
        productTest = new Product(20, 1, "Fisk", 50.0, 25.0);
    }

    @Test
    public void testAddRow() {
        receiptTest.addRow(productTest);
    }
    }
