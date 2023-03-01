package com.demo.dto;

import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;

public class ParkingEvent {
    ParkingEventType parkingEventType;
    ParkingTypeEnum parkingType;

    public ParkingEvent(ParkingEventType parkingEventType, ParkingTypeEnum parkingType) {
        this.parkingEventType = parkingEventType;
        this.parkingType = parkingType;
    }

    public ParkingEventType getType() {
        return parkingEventType;
    }

    public void setType(ParkingEventType parkingEventType) {
        this.parkingEventType = parkingEventType;
    }

    public ParkingTypeEnum getParkingType() {
        return parkingType;
    }

    public void setParkingType(ParkingTypeEnum parkingType) {
        this.parkingType = parkingType;
    }
}
