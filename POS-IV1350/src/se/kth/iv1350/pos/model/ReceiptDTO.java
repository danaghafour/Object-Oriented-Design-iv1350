package se.kth.iv1350.pos.model;
import java.time.LocalTime;

/**
 * A Data Transfer Object for the receipt of the sale
 */
public class ReceiptDTO {
    public double saleTotal;
    public double change;
    public double totalVat;
    public String[] name;
    public double[] price;
    public double[] vat;
    public int[] quantity;
    public LocalTime date;

    /**
     * Creates a new instance of the <code>ReceiptDTO</code> class using a <code>Receipt</code>.
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
}
