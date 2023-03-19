package com.demo.dto.parkingSpot;

import com.demo.dto.*;
import com.demo.enums.*;

import java.util.*;
import java.util.concurrent.atomic.*;

public abstract class ParkingSpot {
    private static final AtomicInteger x = new AtomicInteger(0);
    private int id;
    private boolean isFree;
    private ParkingSpotTypeEnum parkingSpotTypeEnum = ParkingSpotTypeEnum.COMPACT;
    private int floorNumber;
    protected  double amount;

    public ParkingSpot(){
    };

    public ParkingSpot(ParkingSpotTypeEnum parkingSpotTypeEnum, int floorNumber, double amount) {
        this.parkingSpotTypeEnum = parkingSpotTypeEnum;
        this.floorNumber = floorNumber;
        this.amount = amount;
        this.isFree= true;
        id= x.incrementAndGet();
    }

    public int getId() {
        return id;
    }


    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ParkingSpotTypeEnum getParkingTypeEnum() {
        return parkingSpotTypeEnum;
    }
    public abstract int cost(int parkingHours);
}
