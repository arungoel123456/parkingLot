package com.demo.dto.parkingSpot;

import com.demo.enums.*;

public class Large extends ParkingSpot{

    @Override
    public int cost(int parkingHours) {
        return 30*parkingHours;
    }
}
