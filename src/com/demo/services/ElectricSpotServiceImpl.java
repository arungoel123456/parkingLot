package com.demo.services;

import com.demo.dto.parkingSpot.electric.*;
import com.demo.interfaces.*;

public class ElectricSpotServiceImpl implements ElectricSpotService {

    PaymentService paymentService= new PaymentServiceImpl();

    @Override
    public void calculateChargeAndAcceptPayment(Electric parkingSpot)
    {
        double amount = parkingSpot.getElectricPanel().finish();
        paymentService.acceptElectricSpotPayment(amount);
        parkingSpot.getElectricPanel().reset();
    }
}
