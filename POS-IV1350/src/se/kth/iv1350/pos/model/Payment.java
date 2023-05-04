package se.kth.iv1350.pos.model;

/**
 * This class represents a payment made by a customer.
 */

public class Payment {
    private double totalAmount;
    private double change;
    private double paidAmount;

    /**
     * Creates a new instance of Payment with totalAmount and change initialized to 0.
     */
    public Payment(){
        this.totalAmount = 0;
        this.change = 0;
    }

    /**
     * Increases the total amount paid by the customer by the specified amount.
     *
     * @param addToTotalAmount the amount to add to the total amount paid.
     */

    public void addToTotalAmount(double addToTotalAmount){
        this.totalAmount += addToTotalAmount;
    }

    /**
     * Returns the total amount paid by the customer.
     *
     * @return the total amount paid by the customer.
     */

    public double getTotalAmount(){
        return totalAmount;
    }

    /**
     * Calculates the change to give back to the customer based on the amount received.
     *
     * @param amountReceived the amount received from the customer.
     */

    public void calculateChange(double amountReceived){
        change = amountReceived - totalAmount;
        paidAmount = amountReceived;
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

    public double getPaidAmount(double amount) {
        return amount;
    }
}
