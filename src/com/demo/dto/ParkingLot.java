package com.demo.dto;

import com.demo.dto.parkingSpot.*;
import com.demo.dto.vehicle.*;
import com.demo.enums.*;

import java.util.*;

public class ParkingLot {
    private String name;
    private List<EntrancePanel> entrances;
    private List<ExitPanel> exits;
    private DisplayBoard displayBoard;
    private Map<ParkingSpotTypeEnum, List<ParkingSpot>> occupiedParkingSpots;
    private Map<ParkingSpotTypeEnum, List<ParkingSpot>> freeParkingSpots;
    private static ParkingLot parkingLot= null;
    private ParkingLot(){
        entrances= new ArrayList<EntrancePanel>();
        exits= new ArrayList<ExitPanel>();
        displayBoard= DisplayBoard.getInstance();
        occupiedParkingSpots= new HashMap<ParkingSpotTypeEnum, List<ParkingSpot>>();
        freeParkingSpots= new HashMap<ParkingSpotTypeEnum, List<ParkingSpot>>();

        freeParkingSpots.put(ParkingSpotTypeEnum.MINI, new ArrayList<>());
        freeParkingSpots.put(ParkingSpotTypeEnum.COMPACT, new ArrayList<>());
        freeParkingSpots.put(ParkingSpotTypeEnum.LARGE, new ArrayList<>());

        occupiedParkingSpots.put(ParkingSpotTypeEnum.MINI, new ArrayList<>());
        occupiedParkingSpots.put(ParkingSpotTypeEnum.COMPACT, new ArrayList<>());
        occupiedParkingSpots.put(ParkingSpotTypeEnum.LARGE, new ArrayList<>());

        name= "parking lot";
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

    public Map<ParkingSpotTypeEnum, List<ParkingSpot>> getOccupiedParkingSpots() {
        return occupiedParkingSpots;
    }

    public void setOccupiedParkingSpots(Map<ParkingSpotTypeEnum, List<ParkingSpot>> occupiedParkingSpots) {
        this.occupiedParkingSpots = occupiedParkingSpots;
    }

    public Map<ParkingSpotTypeEnum, List<ParkingSpot>> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public void setFreeParkingSpots(Map<ParkingSpotTypeEnum, List<ParkingSpot>> freeParkingSpots) {
        this.freeParkingSpots = freeParkingSpots;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        freeParkingSpots.get(parkingSpot.getParkingTypeEnum()).add(parkingSpot);
    }

}
