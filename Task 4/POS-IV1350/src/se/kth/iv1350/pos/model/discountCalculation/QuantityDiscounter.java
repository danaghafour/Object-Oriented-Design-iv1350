package se.kth.iv1350.pos.model.discountCalculation;

import se.kth.iv1350.pos.model.DatabaseFailureException;
import se.kth.iv1350.pos.model.discountCalculation.Discounter;

import java.math.BigDecimal;

// A concrete strategy class that implements a discount algorithm based on the number of items bought
public class QuantityDiscounter implements Discounter {
    // Add a field to store the number of items bought
    private int quantity;

    // Add a constructor that takes the number of items bought as a parameter
    public QuantityDiscounter(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        try {
            // Fetch the discount rate from the database based on the number of items bought
            // Pass the quantity field to the getDiscountRateFromDatabase method
            BigDecimal discountRate = getDiscountRateFromDatabase(quantity);
            // Check if the discount rate is null before multiplying it with the amount
            if (discountRate != null) {
                // Apply the discount rate to the amount
                return amount.multiply(discountRate);
            } else {
                // Return the original amount without any discount
                return amount;
            }
        } catch (DatabaseFailureException e) {
            // Wrap the checked exception in a runtime exception
            throw new RuntimeException(e);
        }
    }

    // A method that queries the database for the discount rate based on the number of items bought and throws an exception if there is a database failure
    private BigDecimal getDiscountRateFromDatabase(int quantity) throws DatabaseFailureException {
// Connect to the database and execute a query
// For example, you can use JDBC or JPA to access the database
// Return the discount rate as a BigDecimal
// For example, if the number of items bought is 3 or more, return 0.9 as the discount rate (10% off)
// If there is no discount for the given quantity, return null
        switch (quantity) {
            case 1:
                return BigDecimal.valueOf(0.95); // 5% off for one item
            case 2:
                return BigDecimal.valueOf(0.9); // 10% off for two items
            case 3:
                return BigDecimal.valueOf(0.85); // 15% off for three items
            default:
                return null; // no discount for other quantities
        }
    }
}