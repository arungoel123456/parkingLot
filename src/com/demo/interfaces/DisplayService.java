package com.demo.interfaces;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;

import java.util.*;

public class DisplayService {

    public void updateParkingSpotStatus(ParkingSpot parkingSpot)
    {
        DisplayBoard displayBoard= DisplayBoard.getInstance();
        List<ParkingSpot> parkingSpots = displayBoard.getParkingSpots();
        synchronized (parkingSpots){
            parkingSpots.remove(parkingSpot);
            parkingSpot.setFree(!parkingSpot.isFree());
            parkingSpots.add(parkingSpot);
            displayBoard.setParkingSpots(parkingSpots);
        }
        return;
    }
}
