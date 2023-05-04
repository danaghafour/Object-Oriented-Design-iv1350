package se.kth.iv1350.pos.model;

/**
 * This class represents the products
 */
public class Product {
    private int productId;
    private int productQuantity = 0;
    private String productName;
    private double vat;
    private double productPrice;

    /**
     * Create a new instance of Product of type {@link ProductDTO}
     * @param productDTO The product data transfer object
     */
    public Product(ProductDTO productDTO){
        this.productName = productDTO.productName;
        this.productId = productDTO.productID;
        this.productPrice = productDTO.productPrice;
        this.vat = productDTO.productVat;
    }

    /**
     * Create a new instance of Product of type {@link Product}
     * @param product The product
     */
    public Product(Product product){
        this.productId = product.productId;
        this.productPrice = product.productPrice;
        this.productName = product.productName;
        this.vat = product.vat;
    }

    /**
     * Create a new instance of type Product with the parameters:
     * @param productName The name of the product
     * @param productId The product ID
     * @param productPrice The price of the product
     * @param vat The VAT of the product
     * @param productQuantity The quantity of the product
     */

    public Product(int productId, int productQuantity, String productName, double productPrice, double vat){
        this.productId = productId;
        this.vat = vat;
        this.productQuantity = productQuantity;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product(int i, String first_product, double v) {
    }

    /**
     * Returns the price of the product
     * @return The product price
     */
    public double getProductPrice(){
        return productPrice;
    }

    /**
     * Returns the product ID
     * @return The product ID
     */
    public int getProductId(){
        return productId;
    }

    /**
     * Returns the VAT of the product
     * @return The product VAT
     */
    public double getVat(){
        return vat;
    }

/**
 * Returns the quantity of the product
 * @return The product quantity
 */
    public int getProductQuantity(){
        return productQuantity;
    }

    /**
     * Returns the name of the product
     * @return The product name
     */
    public String getProductName(){
        return productName;
    }

    /**
     * Increases the quantity of the product
     * @param moreQuantity The amount to increase the quantity by
     */
    public void increaseQuantity (int moreQuantity){
        this.productQuantity += moreQuantity;
    }

}
