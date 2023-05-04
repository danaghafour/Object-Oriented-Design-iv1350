package se.kth.iv1350.pos.model;


/**
 * A Data Transfer Object for the Product in the sale
 */

public class ProductDTO {
    public int productID;
    public double productVat;
    public int productQuantity;
    public double productPrice;
    public String productName;


    /**
     * Create an instance of the ProductDTO
     *
     * @param productID      the identification number of the product
     * @param productPrice   the price of the product
     * @param productVat     the VAT of the product
     * @param productQuantity the quantity of the product
     * @param productName   the name of the product
     */
    public ProductDTO(int productID, double productPrice, double productVat, int productQuantity, String productName){
        this.productID = productID;
        this.productPrice = productPrice;
        this.productVat = productVat;
        this.productQuantity = productQuantity;
        this.productName = productName;
    }

    /**
     * Create an instance of the ProductDTO using a Product object
     *
     * @param product the Product object to create a DTO from
     */

    public ProductDTO(Product product){
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productID = product.getProductId();
        this.productQuantity = product.getProductQuantity();
        this.productVat = product.getVat();
    }
}
