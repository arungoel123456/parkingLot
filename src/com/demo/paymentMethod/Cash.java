package com.demo.paymentMethod;

public class Cash extends PaymentMethod{

    public Cash() {
//        super(amount);
    }

    @Override
    public boolean initiatePayment(double amount) {
        System.out.println("making payment by cash of Rs " + amount);
        return true;
    }
}
