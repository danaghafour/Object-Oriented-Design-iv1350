package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.AbstractPaymentObserver;


/**
 * Represents a view that displays the total revenue.
 */
public class TotalRevenueObserver extends AbstractPaymentObserver {

    private double totalRevenue;

    /**
     * The TotalRevenueObserver class represents a view that displays the total revenue.
     */
    public TotalRevenueObserver() {
        totalRevenue = 0;
    }

    /**
     * Updates the total revenue and prints the current state.
     *
     * @param newPayment the amount of payment to add to the total revenue
     */
    @Override
    protected void updateTotalRevenue(double newPayment) {
        totalRevenue += newPayment;
        printCurrentState();
    }

    /**
     * Prints the current state of the total revenue.
     */
    @Override
    protected void printCurrentState() {
        System.out.println("\n---------------------");
        System.out.println("Total revenue: " + totalRevenue);
        System.out.println("---------------------\n");
    }

    @Override
    protected void logException(Exception e) {
        System.out.println("Exception: " + e.getMessage());
        e.printStackTrace();
    }
}