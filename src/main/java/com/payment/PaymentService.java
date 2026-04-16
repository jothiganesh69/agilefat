package com.payment;

public class PaymentService {
    public boolean validate(PaymentRequest request) {
        // Validation: Positive amount and 16-digit card
        if (request.getAmount() <= 0) return false;
        if (request.getCardNumber() == null || request.getCardNumber().length() != 16) {
            return false;
        }
        return true;
    }
}
