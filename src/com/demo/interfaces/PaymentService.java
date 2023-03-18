package com.demo.interfaces;

import com.demo.dto.*;

public interface PaymentService {
    public void acceptCreditCardPayment(String cardNumber, int cvv, double amount);
    public void acceptCashPayment(double amount);
}
