package com.demo.dto;

import com.demo.dto.parkingSpot.*;

import java.util.*;

public class DisplayBoard {
    private static DisplayBoard displayBoard= null;
    private List<ParkingSpot> parkingSpots;

    private DisplayBoard() {
        parkingSpots= new ArrayList<>();
    }

    public static DisplayBoard getInstance(){
        if(displayBoard==null){
            displayBoard= new DisplayBoard();
        }
        return displayBoard;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpot) {
        this.parkingSpots = parkingSpot;
    }
}
