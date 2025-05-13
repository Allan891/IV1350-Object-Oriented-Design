package controller;

import static org.junit.jupiter.api.Assertions.*;

import dto.ItemDTO;
import model.Amount;
import model.VAT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ControllerTest {
    private Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller();
        controller.initiateSale();
    }

    @AfterEach
    void tearDown() {
        controller = null;
    }

    @Test
    void testRegisterValidItem() {
        ItemDTO item = controller.registerItem("1");
        assertNotNull(item, "ItemDTO should not be null for valid ID");
        assertEquals("1", item.getItemIdentifier(), "Item ID should match input");
        assertEquals("BigWheel Oatmeal 500 ml", item.getItemDescription(), "Item description should match");
    }

    @Test
    void testRegisterInvalidItem() {
        ItemDTO item = controller.registerItem("invalid-id");
        assertNull(item, "ItemDTO should be null for invalid ID");
    }

    @Test
    void testSimulatedDatabaseFailure() {
        ItemDTO item = controller.registerItem("999"); // Hardcoded to simulate failure
        assertNull(item, "Should return null if DB failure simulated");
        // Optionally check the log file manually or add file check
    }

    @Test
    void testRunningTotalAfterMultipleItems() {
        controller.registerItem("1");
        controller.registerItem("2");
        Amount total = controller.getRunningTotal();
        assertNotNull(total, "Total should not be null after items added");
        assertTrue(total.getAmount() > 0, "Total amount should be greater than zero");
    }

    @Test
    void testEndSaleReturnsCorrectTotal() {
        controller.registerItem("1");
        controller.registerItem("2");
        Amount total = controller.endSale();
        assertNotNull(total, "Total should not be null after ending sale");
        assertTrue(total.getAmount() > 0, "Total must be greater than 0");
    }

    @Test
    void testConcludeSaleReturnsCorrectChange() {
        controller.registerItem("1");
        controller.registerItem("2");
        Amount total = controller.endSale();
        Amount payment = new Amount(200);
        Amount change = controller.concludeSale(payment);
        assertNotNull(change, "Change should not be null");
        assertTrue(change.getAmount() >= 0, "Change should be non-negative");
    }
}
