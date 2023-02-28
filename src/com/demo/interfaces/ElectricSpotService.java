package com.demo.interfaces;

import com.demo.dto.parkingSpot.electric.*;

public interface ElectricSpotService {
    public void calculateChargeAndAcceptPayment(Electric parkingSpot);
}
