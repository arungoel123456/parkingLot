package com.demo.dto;

import com.demo.dto.parkingSpot.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class ParkingFloor {
    private Map<String, ParkingSpot> parkingSpotMap;
    private int floorNumber;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        parkingSpotMap= new HashMap<String, ParkingSpot>();
    }
    public int getFloorNumber() {
        return floorNumber;
    }
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpotMap.put(parkingSpot.getId(), parkingSpot);
    }

    public void removeParkingSpot(ParkingSpot parkingSpot){
        parkingSpotMap.remove(parkingSpot.getId());
    }
}
