package se.kth.iv1350.pos.exceptions;

/**
 * Exception thrown when an item with a specific ID is not found.
 */
public class ProductIDMissingException extends RuntimeException {
    private int productIDMissing;

    /**
     * Constructs a new instance of the exception with the specified product ID.
     *
     * @param productIDMissing the ID of the missing product
     */
    public ProductIDMissingException(int productIDMissing) {
        super("Product with ID " + productIDMissing + " not found in external inventory system.");
        this.productIDMissing = productIDMissing;
    }
    /**
     * Returns the ID of the missing product.
     *
     * @return the ID as an integer
     */
    public int getMissingProductID() {
        return productIDMissing;
    }
}