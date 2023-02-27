package com.demo.dto.payment;

public class Cash extends Payment{

    public Cash(double amount) {
        super(amount);
    }

    @Override
    public boolean initiatePayment() {
        return true;
    }
}
