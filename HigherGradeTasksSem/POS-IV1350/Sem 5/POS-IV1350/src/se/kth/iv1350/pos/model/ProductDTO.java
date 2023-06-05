package se.kth.iv1350.pos.model;


/**
 * A Data Transfer Object (DTO) for a product in the sale.
 */

public class ProductDTO {
    private int productID;
    private double productVat;
    private int productQuantity;
    private double productPrice;
    private String productName;


    /**
     * Creates a new instance of the ProductDTO.
     *
     * @param productID       the identification number of the product.
     * @param productPrice    the price of the product.
     * @param productVat      the VAT of the product.
     * @param productQuantity the quantity of the product.
     * @param productName     the name of the product.
     */

    public ProductDTO(int productID, double productPrice, double productVat, int productQuantity, String productName){
        this.productID = productID;
        this.productPrice = productPrice;
        this.productVat = productVat;
        this.productQuantity = productQuantity;
        this.productName = productName;
    }

    /**
     * Creates a new instance of the ProductDTO based on a Product object.
     *
     * @param product the Product object to create the DTO from.
     */

    public ProductDTO(Product product){
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productID = product.getProductId();
        this.productQuantity = product.getProductQuantity();
        this.productVat = product.getVat();
    }
    public int getProductID(){
        return productID;
    }

    public double getProductPrice(){
        return productPrice;
    }
    public double getProductVat(){
        return productVat;
    }

    public String getProductName(){
        return productName;
    }

    public int getProductQuantity(){
        return productQuantity;
    }
}