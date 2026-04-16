package com.payment;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        // Test Case 1: Valid Payment
        PaymentRequest successReq = new PaymentRequest(250.0, "1234567812345678");
        System.out.println("Testing Valid Payment (250.0, 16-digit card)...");
        System.out.println("Result: " + (service.validate(successReq) ? "PASS" : "FAIL"));

        System.out.println("------------------------------------");

        // Test Case 2: Invalid Payment (Negative Amount)
        PaymentRequest failReq = new PaymentRequest(-10.0, "1234567812345678");
        System.out.println("Testing Invalid Payment (-10.0 amount)...");
        System.out.println("Result: " + (service.validate(failReq) ? "PASS" : "FAIL"));
    }
}
