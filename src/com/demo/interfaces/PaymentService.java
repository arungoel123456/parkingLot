package com.demo.interfaces;

import com.demo.dto.*;

public interface PaymentService {
    public boolean acceptPayment(ParkingTicket parkingTicket);
    public int calculatePrice(ParkingTicket parkingTicket);
}
