package com.demo.dto.payment;

public class CreditCard extends Payment{

    public CreditCard(double amount) {
        super(amount);
    }

    @Override
    public boolean initiatePayment() {
        return true;
    }
}
