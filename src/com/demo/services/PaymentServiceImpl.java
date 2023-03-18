package com.demo.services;

import com.demo.dto.*;
import com.demo.paymentMethod.*;
import com.demo.interfaces.*;

import java.util.*;

public class PaymentServiceImpl implements PaymentService {
    public void acceptCreditCardPayment(String cardNumber, int cvv, double amount){
        PaymentMethod creditCardPayment= new CreditCard(cardNumber,cvv);
        creditCardPayment.initiatePayment(amount);
    }

    public void acceptCashPayment(double amount){
        PaymentMethod cash= new Cash();
        cash.initiatePayment(amount);
    }
}
