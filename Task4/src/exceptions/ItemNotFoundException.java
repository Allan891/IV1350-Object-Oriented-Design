package exceptions;

/**
 * Thrown when an item with the specified identifier does not exist in the inventory.
 */
public class ItemNotFoundException extends Exception {
    private final String itemId;

    public ItemNotFoundException(String itemId) {
        super("Item with identifier '" + itemId + "' was not found.");
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }
}
