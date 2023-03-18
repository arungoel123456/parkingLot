package com.demo.dto;

import com.demo.enums.*;

public class ParkingEvent {
    ParkingEventType parkingEventType;
    ParkingSpotTypeEnum parkingType;

    public ParkingEvent(ParkingEventType parkingEventType, ParkingSpotTypeEnum parkingType) {
        this.parkingEventType = parkingEventType;
        this.parkingType = parkingType;
    }

    public ParkingEventType getType() {
        return parkingEventType;
    }

    public void setType(ParkingEventType parkingEventType) {
        this.parkingEventType = parkingEventType;
    }

    public ParkingSpotTypeEnum getParkingType() {
        return parkingType;
    }

    public void setParkingType(ParkingSpotTypeEnum parkingType) {
        this.parkingType = parkingType;
    }
}
