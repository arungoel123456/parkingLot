package com.demo.services;

import com.demo.dto.*;
import com.demo.interfaces.*;

import java.util.*;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean acceptPayment(ParkingTicket parkingTicket) {
        int price= calculatePrice(parkingTicket);

        // get money from user.
        return false;
    }

    @Override
    public int calculatePrice(ParkingTicket parkingTicket) {
        long parkedHours = new Date().getTime() - parkingTicket.getTimestamp().getTime();
        return (int) (parkedHours*10);
    }
}
