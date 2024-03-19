package se.kth.iv1350.pos.integration;

/**
 * A logger for developers that writes to the console.
 * When exceptions are thrown, the logger is written to.
 */

public class DeveloperLog {

    /**
     * Creates a new instance of the developer logger.
     */
    public DeveloperLog() {}

    /**
     * Writes the exception message to the developer log, which in this case is the console.
     *
     * @param exceptionMessage the message from the exception to be logged
     */
    public void logException(String exceptionMessage) {
        System.out.println("Developer log: " + exceptionMessage + "\n");
    }
}