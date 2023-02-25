package com.demo.dto;

import com.demo.dto.parkingSpot.*;

import java.util.*;

public class DisplayBoard extends ParkingSpotObserver {
    private static DisplayBoard displayBoard= null;
    private HashSet<ParkingSpot> parkingSpots;

    private DisplayBoard() {
        parkingSpots= new HashSet<>();
    }

    public static DisplayBoard getInstance(){
        if(displayBoard==null){
            displayBoard= new DisplayBoard();
        }
        return displayBoard;
    }

    public HashSet<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(HashSet<ParkingSpot> parkingSpot) {
        this.parkingSpots = parkingSpot;
    }

    @Override
    public void update(ParkingSpot parkingSpot) {
        parkingSpots.remove(parkingSpot);
        parkingSpot.setFree(!parkingSpot.isFree());
        parkingSpots.add(parkingSpot);
    }
}
