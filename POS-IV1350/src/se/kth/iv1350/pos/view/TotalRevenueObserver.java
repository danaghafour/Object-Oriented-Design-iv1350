package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.PaymentObserver;

/**
 * Represents a view that displays the total revenue.
 */
public class TotalRevenueObserver implements PaymentObserver {
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
    public void newRevenue(double newPayment) {
        totalRevenue += newPayment;
        printCurrentState();
    }

    /**
     * Prints the current state of the total revenue.
     */
    private void printCurrentState() {
        System.out.println("\n---------------------");
        System.out.println("Total revenue: " + totalRevenue);
        System.out.println("---------------------\n");
    }
}