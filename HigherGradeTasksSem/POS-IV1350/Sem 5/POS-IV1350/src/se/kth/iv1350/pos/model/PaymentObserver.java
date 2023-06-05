package se.kth.iv1350.pos.model;

/**
 * Represents an interface for an observer that observes customer payments.
 */
public interface PaymentObserver {

    /**
     * Called by the observed object when a new payment is made.
     *
     * @param newPayment the amount of the new payment.
     */
    void newRevenue(double newPayment);
}