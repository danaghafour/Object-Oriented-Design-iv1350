package se.kth.iv1350.pos.model;

/**
 * This class represents a data transfer object (DTO) for a payment.
 */
public class PaymentDTO {
    private double totalAmount;
    private double change;

    /**
     * Creates a new instance of the <code>PaymentDTO</code> class based on the information in a {@link Payment} object.
     *
     * @param paymentToDTO the payment object to convert to a DTO.
     */

    public PaymentDTO(Payment paymentToDTO){
        change = paymentToDTO.getChange();
        totalAmount = paymentToDTO.getPayAmount();
    }
    public double getTotalAmount() {
        return totalAmount;
    }
}