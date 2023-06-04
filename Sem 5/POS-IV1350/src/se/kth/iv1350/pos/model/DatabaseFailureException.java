package se.kth.iv1350.pos.model;

// A checked exception class that indicates a database failure
public class DatabaseFailureException extends Exception {
    public DatabaseFailureException(String message) {
        super(message);
    }
}
