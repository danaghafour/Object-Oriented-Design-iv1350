package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.AbstractPaymentObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class TotalRevenueFileOutput extends AbstractPaymentObserver {
    private double totalRevenue;
    private PrintWriter logStream;

    public TotalRevenueFileOutput() {
        try {
            logStream = new PrintWriter(new FileWriter("revenue.txt"), true);
        } catch (IOException ioException) {
            System.out.println("Could not create revenue log file");
            logException(ioException);
        }
    }

    // Updates the total revenue and writes it to the revenue log file
    @Override
    protected void updateTotalRevenue(double newPayment) {
        totalRevenue += newPayment;
        logStream.println("Time: " + LocalTime.now() + " | Total Revenue: " + totalRevenue);
    }

    @Override
    protected void printCurrentState() {
        System.out.println("Total revenue updated.");
    }

    @Override
    protected void logException(Exception e) {
        System.out.println("Exception: " + e.getMessage());
        e.printStackTrace();
    }
}