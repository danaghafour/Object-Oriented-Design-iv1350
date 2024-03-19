package se.kth.iv1350.pos.model;
import java.time.LocalTime;

/**
 * A Data Transfer Object (DTO) for the receipt of the sale.
 */
public class ReceiptDTO {
    private double saleTotal;
    private double change;
    private double totalVat;
    private String[] name;
    private double[] price;
    private double[] vat;
    private int[] quantity;
    private LocalTime date;

    /**
     * Creates a new instance of the <code>ReceiptDTO</code> class using a <code>Receipt</code> object.
     *
     * @param receipt the receipt to create a DTO from.
     */

    public ReceiptDTO(Receipt receipt){
        saleTotal = receipt.getSaleTotal();
        change = receipt.getChange();
        totalVat = receipt.getTotalVat();
        name = receipt.getNameList();
        price = receipt.getPrice();
        vat = receipt.getVatList();
        quantity = receipt.getQuantity();
        date = receipt.getReceiptCreationTime();
    }

    public String[] getName() {
        return name;
    }

    public double[] getPrice() {
        return price;
    }

    public double[] getVat() {
        return vat;
    }

    public double getSaleTotal() {
        return saleTotal;
    }

    public double getTotalVat() {
        return totalVat;
    }

    public double getChange() {
        return change;
    }

    public LocalTime getDate() {
        return date;
    }

    public int[] getQuantity() {
        return quantity;
    }

}