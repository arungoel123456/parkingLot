package com.demo.dto.parkingSpot.spotDecorator;

import com.demo.dto.parkingSpot.*;

public class ElectricCharge extends SpotDecorator{

    public ElectricCharge(ParkingSpot parkingSpot){
        super(parkingSpot);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingSpot.cost(parkingHours) + 50;
    }
}
