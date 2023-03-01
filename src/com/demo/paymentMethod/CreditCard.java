package com.demo.paymentMethod;

public class CreditCard extends PaymentMethod{
    public CreditCard(double amount) {
        super(amount);
    }

    @Override
    public boolean initiatePayment() {
        return false;
    }
}
