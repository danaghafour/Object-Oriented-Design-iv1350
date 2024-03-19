package se.kth.iv1350.pos.exceptions;
/**
 * Exception thrown when the inventory database is not available.
 */
public class InventoryDBException extends RuntimeException{
    /**
     * Creates a new instance of the exception with a default message.
     */
    public InventoryDBException() {
        super("The inventory system server is currently unavailable.");
    }
}