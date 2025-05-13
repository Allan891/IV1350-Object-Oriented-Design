package exceptions;

import integration.ExternalInventorySystem;
import org.junit.Test;

/**
 * Unit test to verify that DatabaseFailureException is correctly thrown.
 */
public class DatabaseFailureExceptionTest {

    @Test(expected = DatabaseFailureException.class)
    public void testDatabaseFailureException() {
        ExternalInventorySystem system = new ExternalInventorySystem();
        system.findItemById("failDB"); // Should simulate DB failure
        }
}
