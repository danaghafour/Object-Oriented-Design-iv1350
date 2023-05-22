package se.kth.iv1350.pos.model;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Represents a sale in the point of sale system.
 */
public class Sale {
    private LocalTime timeOfSale;
    private Payment payment;
    private Receipt salesReceipt;
    private String customerId;

    private ArrayList<Product> currentProducts = new ArrayList<>();

    /**
     * Creates a new instance of the <code>Sale</code> class.
     */
    public Sale(){
        this.timeOfSale = LocalTime.now();
        salesReceipt = new Receipt();
        payment = new Payment();
        this.customerId = customerId;
    }
    public LocalTime getTimeOfSale(){
        return timeOfSale;
    }
    public Payment getPayment(){
        return payment;
    }
    public ArrayList<Product> getCurrentProducts() {
        return currentProducts;
    }
    public Receipt getSalesReceipt(){
        return salesReceipt;
    }

    /**
     * Adds a product to the current sale.
     *
     * @param productToAddToSale the <code>Product</code> to be added to the sale.
     */

    public void addProductToSale(Product productToAddToSale){
        if(isProductInSale(productToAddToSale)){
            for (Product product : currentProducts){
                if(product.getProductId() == productToAddToSale.getProductId()){
                    product.increaseQuantity(1);
                }
            }
        }

        else{
            currentProducts.add(productToAddToSale);
        }
        payment.addToPayAmount(productToAddToSale.getProductPrice());
        salesReceipt.addRow(productToAddToSale);

    }

    /**
     * Checks if a product is already in the current sale.
     *
     * @param product the <code>Product</code> to check.
     * @return <code>true</code> if the product is already in the sale, <code>false</code> otherwise.
     */
    public boolean isProductInSale(Product product) {
        boolean isProductInSale = false;
        for(Product productSearch : currentProducts){
            if(productSearch.getProductId() == product.getProductId())
                isProductInSale = true;
        }
        return isProductInSale;
    }
}