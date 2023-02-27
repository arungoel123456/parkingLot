package com.demo.dto;

import com.demo.dto.parkingSpot.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class ParkingFloor {
    private Map<String, ParkingSpot> parkingSpotMap;

    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpotMap.put(parkingSpot.getId(), parkingSpot);
    }

    public void removeParkingSpot(ParkingSpot parkingSpot){
        parkingSpotMap.remove(parkingSpot.getId());
    }
}
