package exceptions;

import integration.ExternalInventorySystem;
import model.Item;
import org.junit.Test;

/**
 * Unit test to verify that ItemNotFoundException is correctly thrown.
 */
public class ItemNotFoundExceptionTest {

    @Test(expected = ItemNotFoundException.class)
    public void testItemNotFoundException() throws ItemNotFoundException {
        ExternalInventorySystem system = new ExternalInventorySystem();
        system.findItemById("nonexistent"); // Should trigger ItemNotFoundException
    }
}
