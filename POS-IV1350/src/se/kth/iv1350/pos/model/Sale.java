package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.model.discountCalculation.Discounter;

import java.math.BigDecimal;
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
    private Discounter discounter;
    private BigDecimal totalAmount;

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
    // A method that sets the strategy object
    public void setDiscounter(Discounter discounter) {
        this.discounter = discounter;
    }

    // A method that gets the total amount of the sale
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    // A method that uses the strategy object to apply the discount and handles any exceptions that may occur
    public BigDecimal applyDiscount(BigDecimal amount) {
        try {
            // Use the discounter object to apply the discount
            // Convert the double value to a BigDecimal value
            // For example, you can use the BigDecimal.valueOf method
            BigDecimal payAmount = BigDecimal.valueOf(payment.getPayAmount());
            return discounter.applyDiscount(payAmount);
        } catch (DatabaseFailureException e) {
            // Handle the exception here
            // For example, you can print or log an error message for developers and users
            System.out.println("Developer log: " + e.getMessage());
            System.out.println("User message: There was an error when fetching discounts from database.");
            // You can also return a default value or do something else
            // For example, you can return the original amount without any discount
            return amount;
        }
    }
}