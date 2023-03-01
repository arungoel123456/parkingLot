package com.demo.dto.parkingSpot;

import com.demo.enums.*;

public class Compact extends ParkingSpot{

    @Override
    public int cost(int parkingHours) {
        return 20*parkingHours;
    }
}
