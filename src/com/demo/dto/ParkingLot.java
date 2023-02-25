package com.demo.dto;

import com.demo.dto.parkingSpot.*;

import java.util.*;

public class ParkingLot {
    private String name;
    private List<EntrancePanel> entrances;
    private List<ExitPanel> exits;
    private DisplayBoard displayBoard;
    private Map<String , HashSet<ParkingSpot>> occupiedParkingSpots;
    private Map<String , HashSet<ParkingSpot>> freeParkingSpots;
    private static ParkingLot parkingLot= null;
    private ParkingLot(){
        entrances= new ArrayList<EntrancePanel>();
        exits= new ArrayList<ExitPanel>();
        displayBoard= DisplayBoard.getInstance();
    }

    public static ParkingLot getInstance(){
        if(parkingLot== null){
            parkingLot= new ParkingLot();
        }
        return parkingLot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EntrancePanel> getEntrances() {
        return entrances;
    }

    public void setEntrances(List<EntrancePanel> entrances) {
        this.entrances = entrances;
    }

    public void addEntrancePanel(EntrancePanel entrancePanel)
    {
        entrances.add(entrancePanel);
    }

    public List<ExitPanel> getExits() {
        return exits;
    }

    public void setExits(List<ExitPanel> exits) {
        this.exits = exits;
    }
    public void addExitPanel(ExitPanel exitPanel)
    {
        exits.add(exitPanel);
    }


    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public void setDisplayBoard(DisplayBoard displayBoard) {
        this.displayBoard = displayBoard;
    }

    public Map<String, HashSet<ParkingSpot>> getOccupiedParkingSpots() {
        return occupiedParkingSpots;
    }

    public void setOccupiedParkingSpots(Map<String, HashSet<ParkingSpot>> occupiedParkingSpots) {
        this.occupiedParkingSpots = occupiedParkingSpots;
    }

    public Map<String, HashSet<ParkingSpot>> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public void setFreeParkingSpots(Map<String, HashSet<ParkingSpot>> freeParkingSpots) {
        this.freeParkingSpots = freeParkingSpots;
    }
}
