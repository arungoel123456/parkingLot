package com.demo.services;

import com.demo.interfaces.*;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean acceptPayment() {
        return false;
    }

    @Override
    public int calculatePrice() {
        return 0;
    }
}
