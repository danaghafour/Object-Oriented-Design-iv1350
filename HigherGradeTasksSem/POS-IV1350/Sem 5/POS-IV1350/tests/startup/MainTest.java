package startup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.startup.Main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

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
    void testMain() {
        Main.main(new String[0]);
        String expectedOutput = "Product ID was not found in the inventory system.\n" +
                "Developer log: The inventory system server is currently unavailable.\n" +
                "\n" +
                "Inventory system server is down.\n" +
                "Product ID was not found in the inventory system.\n" +
                "Products in sale:\n" +
                "Price of products in sale: \n" +
                "Quantity of products in sale: \n" +
                "Price of products in sale: 0.0\n" +
                "\n" +
                "---------------------\n" +
                "Total revenue: 0.0\n" +
                "---------------------\n" +
                "\n" +
                "\n" +
                "---------------------\n" +
                "Total revenue: 0.0\n" +
                "---------------------\n" +
                "\n" +
                "Total revenue updated.\n" +
                "Product ID was not found in the inventory system.\n" +
                "Product ID was not found in the inventory system.\n" +
                "Products in sale:\n" +
                "Eggs\n" +
                "Price of products in sale: \n" +
                "25.0\n" +
                "Quantity of products in sale: \n" +
                "1\n" +
                "Price of products in sale: 25.0\n" +
                "\n" +
                "---------------------\n" +
                "Total revenue: 25.0\n" +
                "---------------------\n" +
                "\n" +
                "\n" +
                "---------------------\n" +
                "Total revenue: 25.0\n" +
                "---------------------\n" +
                "\n" +
                "Total revenue updated.\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}