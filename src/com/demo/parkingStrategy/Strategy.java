package com.demo.parkingStrategy;

import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;
import com.demo.exceptions.*;

import java.util.*;

public interface Strategy {
    public ParkingSpot findParkingSpot(ParkingSpotTypeEnum parkingSpotType) throws SpotNotFoundException;
    public void addParkingSpot(List<ParkingSpot> parkingSpots, ParkingSpot parkingSpot);
}
