package se.kth.iv1350.pos.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.model.Payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentTest {
    private Payment payment;

    @BeforeEach
    public void init() {
        payment = new Payment();
    }

    @Test
    public void testAddToTotalAmount() {
        payment.addToTotalAmount(50.0);
        assertEquals(50.0, payment.getTotalAmount());
    }

    @Test
    public void testCalculateChange() {
        payment.addToTotalAmount(50.0);
        payment.calculateChange(100.0);
        assertEquals(50.0, payment.getChange());
        assertEquals(100.0, payment.getPaidAmount(100));
    }
}
