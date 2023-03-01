package com.demo.parkingStrategy;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;
import com.demo.exceptions.*;

import java.util.*;

public class FarthestFirstStrategy implements Strategy{
    private ParkingLot parkingLot;
    public FarthestFirstStrategy(){
        parkingLot= ParkingLot.getInstance();
    }

    @Override
    public ParkingSpot findParkingSpot(ParkingTypeEnum parkingSpotType) throws SpotNotFoundException {
        List<ParkingSpot> freeParkingSpots= parkingLot.getFreeParkingSpots().get(parkingSpotType);
        if(freeParkingSpots.size()==0) throw new SpotNotFoundException("Spot not found");

        return freeParkingSpots.get(freeParkingSpots.size()-1);
    }

    @Override
    public void addParkingSpot(List<ParkingSpot> parkingSpots, ParkingSpot parkingSpot) {

    }

}
