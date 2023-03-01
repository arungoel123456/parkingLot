package com.demo.dto.parkingSpot;

import com.demo.dto.*;
import com.demo.enums.*;

import java.util.*;

public abstract class ParkingSpot {
    private String id;
    private boolean isFree;
    private ParkingTypeEnum parkingTypeEnum= ParkingTypeEnum.COMPACT;
    private ParkingFloor parkingFloor;
    protected  double amount;

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingSpot that)) return false;
        return id.equals(that.id) && parkingFloor.equals(that.parkingFloor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parkingFloor);
    }
    public ParkingTypeEnum getParkingTypeEnum() {
        return parkingTypeEnum;
    }
    public abstract int cost(int parkingHours);
}
