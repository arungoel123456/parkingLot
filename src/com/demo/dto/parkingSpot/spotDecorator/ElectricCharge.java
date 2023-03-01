package com.demo.dto.parkingSpot.spotDecorator;

import com.demo.dto.parkingSpot.*;

public class ElectricCharge extends SpotDecorator{
    private ParkingSpot parkingSpot;

    public ElectricCharge(ParkingSpot parkingSpot){
        this.parkingSpot= parkingSpot;
    }

    @Override
    public int cost(int parkingHours) {
        return parkingSpot.cost(parkingHours) + 50;
    }
}
