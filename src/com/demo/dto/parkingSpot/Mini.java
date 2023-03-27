package com.demo.dto.parkingSpot;

import com.demo.enums.*;

public class Mini extends ParkingSpot {

    public Mini(Integer floorNumber) {
        super(ParkingSpotTypeEnum.MINI , floorNumber, 10);
    }

    @Override
    public int cost(int parkingHours) {
        return (int) amount *parkingHours;
    }
}
