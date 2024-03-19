package model;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.model.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PaymentTest {
    private Payment payment = new Payment();

    @Test
    void increaseAmountToPaySuccess(){
        payment.addToPayAmount(10);
        double amountTest = payment.getPayAmount();
        assertEquals(10, amountTest, "The pay amount should be increased by 10 after adding 10.");
    }

    @Test
    void increaseAmountToPayFail(){
        payment.addToPayAmount(10);
        double amountTest = payment.getPayAmount();
        assertNotEquals(9, amountTest, "The pay amount should not be 9 after adding 10.");
    }

    @Test
    void payAmountFail(){
        payment.addToPayAmount(10);
        payment.calculateChange(9);
        double changeTest = payment.getChange();
        assertNotEquals(2, changeTest);
    }

    @Test
    void payAmountSuccess(){
        payment.addToPayAmount(10);
        payment.calculateChange(9);
        double changeTest = payment.getChange();
        assertEquals(1, changeTest);
    }
}
