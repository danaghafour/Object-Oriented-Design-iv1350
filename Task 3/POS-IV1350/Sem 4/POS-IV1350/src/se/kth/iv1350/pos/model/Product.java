package se.kth.iv1350.pos.model;

public class Product {
    private int productId;
    private int productQuantity = 0;
    private String productName;
    private double vat;
    private double productPrice;

    /**
     * Creates a new instance of Product based on a ProductDTO.
     *
     * @param productDTO the product data transfer object.
     */

    public Product(ProductDTO productDTO){
        this.productName = productDTO.getProductName();
        this.productId = productDTO.getProductID();
        this.productPrice = productDTO.getProductPrice();
        this.vat = productDTO.getProductVat();
    }

    /**
     * Creates a new instance of Product based on another Product.
     *
     * @param product the product to create a new instance from.
     */

    public Product(Product product){
        this.productId = product.productId;
        this.productPrice = product.productPrice;
        this.productName = product.productName;
        this.vat = product.vat;
    }

    /**
     * Creates a new instance of Product with the specified parameters.
     *
     * @param productId       the ID of the product.
     * @param productQuantity the quantity of the product.
     * @param productName     the name of the product.
     * @param productPrice    the price of the product.
     * @param vat             the VAT of the product.
     */

    public Product(int productId, int productQuantity, String productName, double productPrice, double vat){
        this.productId = productId;
        this.vat = vat;
        this.productQuantity = productQuantity;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public double getProductPrice(){
        return productPrice;
    }
    public int getProductId(){
        return productId;
    }
    public double getVat(){
        return vat;
    }
    public int getProductQuantity(){
        return productQuantity;
    }
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