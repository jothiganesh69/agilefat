package com.payment;

public class PaymentRequest {
    private double amount;
    private String cardNumber;

    public PaymentRequest(double amount, String cardNumber) {
        this.amount = amount;
        this.cardNumber = cardNumber;
    }

    public double getAmount() { return amount; }
    public String getCardNumber() { return cardNumber; }
}
