package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.PaymentObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

/**
 * A class that outputs total revenue to a file and implements the {@link PaymentObserver} interface.
 */
public class TotalRevenueFileOutput implements PaymentObserver {
    private double totalRevenue;
    private PrintWriter logStream;

    /**
     * Creates a new file in the reports folder to write the revenue log.
     */
    public TotalRevenueFileOutput() {
        try {
            logStream = new PrintWriter(new FileWriter("revenue.txt"), true);
        } catch (IOException ioException) {
            System.out.println("Could not create revenue log file");
            ioException.printStackTrace();
        }
    }

    /**
     * Writes the updated total revenue to the revenue log file.
     *
     * @param newPayment the new payment that increases the total revenue
     */
    @Override
    public void newRevenue(double newPayment) {
        totalRevenue += newPayment;
        logStream.println("Time: " + LocalTime.now() + " | Total Revenue: " + totalRevenue);
    }
}