package com.demo.interfaces;

import com.demo.dto.*;

public interface PaymentService {
    public boolean acceptPayment(ParkingTicket parkingTicket);
    public double calculatePrice(ParkingTicket parkingTicket);
    public boolean acceptElectricSpotPayment(double amount);
}
