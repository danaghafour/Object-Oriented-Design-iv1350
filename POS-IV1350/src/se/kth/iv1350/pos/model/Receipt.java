package se.kth.iv1350.pos.model;

import java.time.LocalTime;

/**
 * This class represents the receipt and the information it contains.
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
    /**
     * Returns an array of the quantities of each product in the receipt.
     *
     * @return an array of integers representing the quantities of each product in the receipt.
     */
    public int[] getQuantity(){
        return quantity;
    }

    /**
     * Sets the change due to the customer.
     *
     * @param changeFromSale the change due to the customer.
     */

    public void setChange(double changeFromSale){
        change = changeFromSale;
    }

    /**
     * Returns the change due to the customer.
     *
     * @return the change due to the customer.
     */
    public double getChange(){
        return change;
    }

    /**
     * Returns the name of a product at a specific index in the receipt.
     *
     * @param indexInName the index of the product name to retrieve
     * @return the name of the product at the specified index.
     */
    public String getItemNameBasedOnIndex(int indexInName){
        return name[indexInName];
    }
    /**
     * Returns an array of the prices of each product in the receipt.
     *
     * @return an array of doubles representing the prices of each product in the receipt.
     */
    public double[] getPrice() {
        return price;
    }
    /**
     * Returns an array of the names of each product in the receipt.
     *
     * @return an array of strings representing the names of each product in the receipt.
     */
    public String[] getNameList(){
        return name;
    }
    /**
     * Returns an array of the VAT rates of each product in the receipt.
     *
     * @return an array of doubles representing the VAT rates of each product in the receipt.
     */
    public double[] getVatList(){
        return vat;
    }
    /**
     * Returns the total VAT for all products in the receipt.
     *
     * @return the total VAT for all products in the receipt.
     */
    public double getTotalVat(){
        return totalVat;
    }
    /**
     * Returns the total sale amount for all products in the receipt.
     *
     * @return the total sale amount for all products in the receipt.
     */
    public double getSaleTotal() {
        return saleTotal;
    }
    /**
     * Returns the time of creation for the receipt.
     *
     * @return the time of creation for the receipt.
     */
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
