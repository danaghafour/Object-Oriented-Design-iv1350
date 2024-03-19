package se.kth.iv1350.pos.model;

import java.time.LocalTime;

/**
 * This class represents a receipt and the information it contains.
 */
public class Receipt {
    private double saleTotal;
    private double change;
    private double totalVat;
    private String[] name = new String[0];
    private double[] price = new double[0];
    private double[] vat = new double[0];
    private int[] quantity = new int[0];
    private LocalTime receiptCreationTime;
    private int receiptRowPos = 0;

    /**
     * Creates a new instance of the Receipt class with the current time of creation.
     */

    public Receipt(){
        this.receiptCreationTime = LocalTime.now();
    }
    public int[] getQuantity(){
        return quantity;
    }
    public void setChange(double changeFromSale){
        change = changeFromSale;
    }
    public double getChange(){
        return change;
    }
    public String getProductNameBasedOnIndex(int indexInName){
        return name[indexInName];
    }
    public double[] getPrice() {
        return price;
    }
    public String[] getNameList(){
        return name;
    }
    public double[] getVatList(){
        return vat;
    }
    public double getTotalVat(){
        return totalVat;
    }
    public double getSaleTotal() {
        return saleTotal;
    }
    public LocalTime getReceiptCreationTime(){
        return receiptCreationTime;
    }
    /**
     * Adds a product to the receipt.
     *
     * @param addProductToReceipt the product to add to the receipt.
     */
    public void addRow(Product addProductToReceipt){
    }
}