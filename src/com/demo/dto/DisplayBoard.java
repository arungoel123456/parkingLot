package com.demo.dto;

import com.demo.dto.parkingSpot.*;

import java.util.*;

public class DisplayBoard {
    private Map<String, List<ParkingSpot>> parkingSpotCounts;
    private static DisplayBoard displayBoard= null;

    private DisplayBoard() {
        parkingSpotCounts = new HashMap<>();
    }

    public static DisplayBoard getInstance(){
        if(displayBoard==null){
            displayBoard= new DisplayBoard();
        }
        return displayBoard;
    }

    public Map<String, List<ParkingSpot>> getParkingSpotCounts() {
        return parkingSpotCounts;
    }
}
