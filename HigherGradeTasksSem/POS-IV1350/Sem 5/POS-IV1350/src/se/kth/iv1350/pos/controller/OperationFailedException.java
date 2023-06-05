package se.kth.iv1350.pos.controller;
/**
 * Exception thrown when an operation fails.
 */
public class OperationFailedException extends Exception {

    /**
     * Creates a new instance of the exception with a message and a cause.
     *
     * @param message the message for the exception
     * @param cause the cause of the exception
     */
    public OperationFailedException(String message, Exception cause){
        super(message, cause);
    }
}