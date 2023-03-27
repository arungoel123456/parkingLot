package com.demo.dto.parkingSpot;

import com.demo.enums.*;

public class Large extends ParkingSpot{

    public Large( Integer floorNumber) {
        super(ParkingSpotTypeEnum.LARGE , floorNumber, 30);
    }

    @Override
    public int cost(int parkingHours) {
        return (int) amount *parkingHours;
    }
}
