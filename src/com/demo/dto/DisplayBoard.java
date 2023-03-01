package com.demo.dto;

import com.demo.dto.parkingSpot.*;

import java.util.*;

public class DisplayBoard {
    private static DisplayBoard displayBoard= null;
    private HashSet<ParkingSpot> parkingSpots;
    private int freeParkingSpotCount;
    private int occupiedParkingSpotCount;

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

    public int getFreeParkingSpotCount() {
        return freeParkingSpotCount;
    }

    public void setFreeParkingSpotCount(int freeParkingSpotCount) {
        this.freeParkingSpotCount = freeParkingSpotCount;
    }

    public int getOccupiedParkingSpotCount() {
        return occupiedParkingSpotCount;
    }

    public void setOccupiedParkingSpotCount(int occupiedParkingSpotCount) {
        this.occupiedParkingSpotCount = occupiedParkingSpotCount;
    }
}
