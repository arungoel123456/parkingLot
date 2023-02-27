package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.payment.*;
import com.demo.interfaces.*;

import java.util.*;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean acceptPayment(ParkingTicket parkingTicket) {
        double price= calculatePrice(parkingTicket);
        Payment payment= new CreditCard(price);
        return payment.initiatePayment();
    }

    @Override
    public double calculatePrice(ParkingTicket parkingTicket) {
        long parkedHours = new Date().getTime() - parkingTicket.getTimestamp().getTime();
        return parkedHours*10;
    }

    @Override
    public boolean acceptElectricSpotPayment(double amount){
        Payment payment= new CreditCard(amount);
        return payment.initiatePayment();
    }
}
