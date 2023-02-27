package com.demo.dto.payment;

public abstract class Payment {
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract boolean initiatePayment();
}
