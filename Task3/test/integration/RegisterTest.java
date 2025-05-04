package test.integration;

import integration.Register;
import model.Amount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {

    @Test
    void testUpdateRegisterWithoutReflection() {
        Register register = new Register(new Amount(100.0));
        register.updateRegister(new Amount(50.0));

        Amount expectedAmount = new Amount(150.0);
        assertEquals(expectedAmount.getAmount(), register.getAmount().getAmount(), 0.001,
            "Register should reflect updated total after sale.");
    }
}
