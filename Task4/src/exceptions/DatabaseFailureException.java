package exceptions;

/**
 * Thrown when the inventory system fails to connect to the database.
 */
public class DatabaseFailureException extends RuntimeException {
    public DatabaseFailureException(String message) {
        super("Database failure: " + message);
    }
}
