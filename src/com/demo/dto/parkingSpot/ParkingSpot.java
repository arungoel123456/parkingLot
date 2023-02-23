package com.demo.dto.parkingSpot;

import com.demo.dto.*;

public abstract class ParkingSpot {
    private String id;
    private boolean isFree;
    private ParkingFloor parkingFloor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}
