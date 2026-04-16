package com.payment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {
    PaymentService service = new PaymentService();

    @Test
    void testTransactionSuccess() {
        // Correct amount and 16-digit card
        PaymentRequest req = new PaymentRequest(100.0, "1234567812345678");
        assertTrue(service.validate(req), "Transaction should succeed");
    }

    @Test
    void testTransactionFailure() {
        // Bad card length and zero amount
        PaymentRequest req = new PaymentRequest(0.0, "123");
        assertFalse(service.validate(req), "Transaction should fail");
    }
}
