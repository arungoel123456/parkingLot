package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.interfaces.*;

import java.util.*;

public class DisplayServiceImpl implements DisplayService {

    public boolean checkSpot(String spot){
        DisplayBoard displayBoard=  DisplayBoard.getInstance();
        return displayBoard.getParkingSpotCounts().get(spot).size()>0;
    }
    @Override
    public ParkingSpot getParkingSpot(String spot){
        DisplayBoard displayBoard=  DisplayBoard.getInstance();
        if(!checkSpot(spot)){
            return null;
        }
        return displayBoard.getParkingSpotCounts().get(spot).remove(0);
    }

    @Override
    public void addFreeParkingSpot(ParkingSpot parkingSpot) {
        DisplayBoard displayBoard=  DisplayBoard.getInstance();
        Map<String, List<ParkingSpot>> parkingSpotCounts = displayBoard.getParkingSpotCounts();
        if(parkingSpot.getClass() == Compact.class){
            List<ParkingSpot> compactParkingSpots= parkingSpotCounts.get("compact");
            compactParkingSpots.add(parkingSpot);
            parkingSpotCounts.put( "compact", compactParkingSpots) ;
        }
        else if(parkingSpot.getClass() == Electric.class){
            List<ParkingSpot> electricParkingSpots= parkingSpotCounts.get("electric");
            electricParkingSpots.add(parkingSpot);
            parkingSpotCounts.put( "electric", electricParkingSpots) ;
        }
        // same goes for other spots.
    }
}
