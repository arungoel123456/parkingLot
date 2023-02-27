package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.dto.parkingSpot.electric.*;
import com.demo.dto.payment.*;
import com.demo.interfaces.*;

public class ElectricSpotService {

    PaymentService paymentService= new PaymentServiceImpl();
    public void calculateChargeAndAcceptPayment(Electric parkingSpot)
    {
        double amount = parkingSpot.getElectricPanel().finish();
        paymentService.acceptElectricSpotPayment(amount);
    }
}
