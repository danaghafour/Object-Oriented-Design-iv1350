package se.kth.iv1350.pos.model;
import se.kth.iv1350.pos.integration.TotalRevenueFileOutput;

import java.util.*;

/**
 * This class represents a payment made by a customer.
 */

public class Payment {
    private double payAmount;
    private double change;
    private double paidAmount;
    private List<AbstractPaymentObserver> paymentObservers = new ArrayList<>();

    private TotalRevenueFileOutput totalRevenueFileOutput;

    public static final double FIRST_PAYMENT = 250;
    public static final double SECOND_PAYMENT = 300;
    /**
     * Creates a new instance of Payment with payAmount and change initialized to 0.
     */
    public Payment(){
        this.payAmount = 0;
        this.change = 0;
    }

    /**
     * Increases the total amount paid by the customer by the specified amount.
     *
     * @param addPayAmount the amount to add to the total amount paid.
     */

    public void addToPayAmount(double addPayAmount){
        this.payAmount += addPayAmount;
    }

    /**
     * Returns the total amount paid by the customer.
     *
     * @return the total amount paid by the customer.
     */

    public double getPayAmount(){
        return payAmount;
    }

    /**
     * Calculates the change to give back to the customer based on the amount received.
     *
     * @param amountReceived the amount received from the customer.
     */

    public void calculateChange(double amountReceived){
        change = amountReceived - payAmount;
        paidAmount = amountReceived;
        notifyPaymentObservers();
        updateRecordedPaymentsLog();
    }

    /**
     * Sets a class that can output to a file for this class.
     *
     * @param totalRevenueFileOutput the class that outputs to a file.
     */

    public void setTotalRevenue(TotalRevenueFileOutput totalRevenueFileOutput) {
        this.totalRevenueFileOutput = totalRevenueFileOutput;
    }

    /**
     * Registers observers that will be notified when Payment changes state.
     *
     * @param paymentObserver the observer that will be notified of the change.
     */
    public void addPaymentObservers(List<AbstractPaymentObserver> paymentObserver) {
        paymentObservers.addAll(paymentObserver);
    }

    /**
     * Notifies observers for the Payment class with the amount for sale.
     */
    private void notifyPaymentObservers(){
        for (AbstractPaymentObserver paymentObserver : paymentObservers) {
            paymentObserver.newRevenue(paidAmount - change);
        }
    }

    /**
     * Updates the amount for sale that updates the log.
     */
    private void updateRecordedPaymentsLog() {
        totalRevenueFileOutput.newRevenue(paidAmount - change);
    }

    /**
     * Returns the amount of change to give back to the customer.
     *
     * @return the amount of change to give back to the customer.
     */
    public double getChange(){
        return change;
    }

    /**
     * Returns the amount of money paid by the customer.
     *
     * @return the amount of money paid by the customer.
     */

    public double getPaidAmount() {
        return paidAmount;
    }
}