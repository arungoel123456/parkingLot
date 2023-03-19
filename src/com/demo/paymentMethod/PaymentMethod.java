package com.demo.paymentMethod;

public abstract class PaymentMethod {
//    protected double amount;
//
//    public PaymentMethod(double amount) {
//        this.amount = amount;
//    }

    public abstract boolean initiatePayment(double amount);
}
