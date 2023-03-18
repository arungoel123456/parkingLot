package com.demo.dto.parkingSpot;

import com.demo.enums.*;

public class Compact extends ParkingSpot{
    public Compact(Integer floorNumber) {
        super(ParkingSpotTypeEnum.COMPACT, floorNumber, 20);
    }

    @Override
    public int cost(int parkingHours) {
        System.out.println(parkingHours + 10);
        return (int) amount*10;
    }
}
