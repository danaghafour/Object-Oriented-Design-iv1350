package se.kth.iv1350.pos.model.discountCalculation;

import se.kth.iv1350.pos.model.discountCalculation.Discounter;

import java.math.BigDecimal;

// Another concrete strategy class that implements a discount algorithm based on the customer id
public class CustomerDiscounter implements Discounter {
    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        // Fetch the discount rate from the database based on the customer id
        BigDecimal discountRate = getDiscountRateFromDatabase();
        // Apply the discount rate to the amount
        return amount.multiply(discountRate);
    }

    // A method that queries the database for the discount rate based on the customer id
    private BigDecimal getDiscountRateFromDatabase() {
        // Connect to the database and execute a query
        // For example, you can use JDBC or JPA to access the database
        // Return the discount rate as a BigDecimal
        // For example, if the customer id is 1234, return 0.9 as the discount rate (10% off)
        return null;
    }
}