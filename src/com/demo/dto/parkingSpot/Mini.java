package com.demo.dto.parkingSpot;

public class Mini extends ParkingSpot {

    @Override
    public int cost(int parkingHours) {
        return 10*parkingHours;
    }
}
