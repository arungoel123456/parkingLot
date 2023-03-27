package com.demo.dto.vehicle;

import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;

public class Car extends Vehicle{
    public Car() {
        super(ParkingSpotTypeEnum.COMPACT);
    }
}
