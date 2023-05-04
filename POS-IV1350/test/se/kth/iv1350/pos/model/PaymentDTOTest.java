package se.kth.iv1350.pos.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.model.Payment;
import se.kth.iv1350.pos.model.PaymentDTO;

public class PaymentDTOTest {

    @Test
    public void testPaymentDTOConstructor() {
        Payment payment = new Payment();
        payment.addToTotalAmount(50.0);
        payment.calculateChange(100.0);

        PaymentDTO dto = new PaymentDTO(payment);
        assertEquals(payment.getChange(), dto.change);
        assertEquals(payment.getTotalAmount(), dto.totalAmount);
    }
}
