package com.demo.paymentMethod;

public class CreditCard extends PaymentMethod{
    private String cardNumber;
    private int cvv;
    public CreditCard(String cardNumber, int cvv) {
//        super(amount);
        this.cardNumber= cardNumber;
        this.cvv= cvv;
    }

    @Override
    public boolean initiatePayment(double amount) {
        System.out.println("Making payment at "+ cardNumber+ " with "+ cvv+ " : " + amount);
        return true;
    }
}
