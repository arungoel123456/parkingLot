package com.demo.paymentMethod;

public class Cash extends PaymentMethod{

    public Cash(double amount) {
        super(amount);
    }

    @Override
    public boolean initiatePayment() {
        return false;
    }
}
