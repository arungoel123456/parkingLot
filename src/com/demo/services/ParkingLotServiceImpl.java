package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.interfaces.*;

import java.util.*;

public class ParkingLotServiceImpl implements ParkingLotService {

    public boolean checkSpot(String spot){
        DisplayBoard displayBoard=  DisplayBoard.getInstance();
        return displayBoard.getParkingSpotCounts().get(spot).size()>0;
    }
    @Override
    public ParkingSpot getParkingSpot(String spot){
        ParkingLot parkingLot= ParkingLot.getInstance();
        Map<String, List<ParkingSpot>> freeParkingSpots= parkingLot.getFreeParkingSpots();
        Map<String, List<ParkingSpot>> occupiedParkingSpots= parkingLot.getOccupiedParkingSpots();

        // reading parking spot
        if(freeParkingSpots.get(spot).size() > 0){
            synchronized (freeParkingSpots.get(spot)){
                ParkingSpot parkingSpot= freeParkingSpots.get(spot).remove(0);
                occupiedParkingSpots.get(spot).add(parkingSpot);
                parkingLot.setFreeParkingSpots(freeParkingSpots);
                parkingLot.setOccupiedParkingSpots(occupiedParkingSpots);
                return parkingSpot;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public void addFreeParkingSpot(ParkingSpot parkingSpot) {
        String parkingSpotType= getParkingSpotType(parkingSpot);
        ParkingLot parkingLot= ParkingLot.getInstance();
        Map<String, List<ParkingSpot>> freeParkingSpots= parkingLot.getFreeParkingSpots();
        Map<String, List<ParkingSpot>> occupiedParkingSpots= parkingLot.getOccupiedParkingSpots();

        synchronized (freeParkingSpots.get(parkingSpotType)){
            freeParkingSpots.get(parkingSpotType).add(parkingSpot);
            parkingLot.setFreeParkingSpots(freeParkingSpots);
            occupiedParkingSpots.get(parkingSpotType).remove(parkingSpot);
            parkingLot.setOccupiedParkingSpots(occupiedParkingSpots);
        }
    }

    public String getParkingSpotType(ParkingSpot parkingSpot){
        if(parkingSpot.getClass() == Compact.class){
            return "compact";
        }
        else if(parkingSpot.getClass() == Electric.class){
            return "electric";
        }
        else if(parkingSpot.getClass() == Large.class){
            return "large";
        }
        return "";
    }
}
