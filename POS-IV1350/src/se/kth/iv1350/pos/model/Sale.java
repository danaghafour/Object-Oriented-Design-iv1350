package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Sale {
    private LocalTime timeOfSale;
    private Payment customerPayment;
    private Receipt salesReceipt;
    private double discount;
    private ArrayList<Product> currentProducts = new ArrayList<>();

    /**
     * Creates a new instance of Sale which contains different details about the sale.
     *
     */
    public Sale(){
        this.timeOfSale = LocalTime.now();
        salesReceipt = new Receipt();
        customerPayment = new Payment();
    }

    /**
     * Private method that stores the time and date of the sale when it starts
     */
    private void timeAndDateOfSale(){
        timeOfSale = LocalTime.now();
    }

    /**
     * Retrieves the time when the sale started.
     *
     * @return the timeOfSale of this Sale object
     */
    public LocalTime getTimeOfSale(){
        return timeOfSale;
    }

    /**
     * Retrieves the customer's payment.
     *
     * @return the customerPayment of this Sale object
     */
    public Payment getCustomerPayment(){
        return customerPayment;
    }

    /**
     * Retrieves the current products in the sale.
     *
     * @return the currentProducts of this Sale object
     */
    public ArrayList<Product> getCurrentProducts() {
        return currentProducts;
    }

    /**
     * Retrieves the discount of the sale.
     *
     * @return the discount of this Sale object
     */

    public double getDiscount() {
        return discount;
    }

    /**
     * Retrieves the sales receipt.
     *
     * @return the salesReceipt of this Sale object
     */
    public Receipt getSalesReceipt(){
        return salesReceipt;
    }

    /**
     * Updates the systems with the sale information.
     *
     * @param saleUpdate the updated sale information
     */

    public void updateSystems(Sale saleUpdate){

    }

    /**
     * Checks if the product is already scanned.
     *
     * @param product the product to be checked
     * @return true if the product is already scanned, otherwise false
     */
    public boolean ifProductScanned(Product product){
        boolean ifProductScanned = false;

        if(product == null){
            return ifProductScanned;
        }

        for(Product productCheck : currentProducts){
            if (productCheck.getProductId() == product.getProductId()){
                ifProductScanned = true;
            }
        }
        return ifProductScanned;
    }

    /**
     * Adds the new product to the sale.
     *
     * @param productToAddToSale the product to be added to the sale
     */

    public void addProductToSale(Product productToAddToSale){
        if(ifProductScanned(productToAddToSale)){
            for (Product product : currentProducts){
                if(product.getProductId() == productToAddToSale.getProductId()){
                    product.increaseQuantity(1);
                }
            }
        }

        else{
            currentProducts.add(productToAddToSale);
        }

            customerPayment.addToTotalAmount(productToAddToSale.getProductPrice());
            salesReceipt.addRow(productToAddToSale);

    }

    public boolean isProductInSale(Product product) {
        boolean isProductInSale = false;
        if(product == null) {
            return isProductInSale;
        }
        for(Product productSearch : currentProducts){
            if(productSearch.getProductId() == product.getProductId())
                isProductInSale = true;
        }
    return isProductInSale;
    }

}
