package se.kth.iv1350.pos.model.discountCalculation;

import se.kth.iv1350.pos.model.DatabaseFailureException;

import java.math.BigDecimal;

// The strategy interface that declares a common method for all discount algorithms
public interface Discounter {
    // Declare that the method may throw a DatabaseFailureException
    BigDecimal applyDiscount(BigDecimal amount) throws DatabaseFailureException;
}