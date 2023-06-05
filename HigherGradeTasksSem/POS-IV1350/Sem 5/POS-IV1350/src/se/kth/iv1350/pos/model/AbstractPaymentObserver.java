package se.kth.iv1350.pos.model;

public abstract class AbstractPaymentObserver implements PaymentObserver {

    public final void newRevenue(double newPayment) {
        updateTotalRevenue(newPayment);
        printCurrentState();
    }

    protected abstract void updateTotalRevenue(double newPayment);

    protected abstract void printCurrentState();

    protected abstract void logException(Exception e);
}