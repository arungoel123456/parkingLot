package com.demo.dto;

import java.util.*;

public class ParkingLot {
    private String name;
    private List<EntrancePanel> entrances;
    private List<ExitPanel> exits;
    private List<ParkingFloor> floors;
    private DisplayBoard displayBoard;
    private static ParkingLot parkingLot= null;
    private ParkingLot(){
        entrances= new ArrayList<EntrancePanel>();
        exits= new ArrayList<ExitPanel>();
        floors= new ArrayList<ParkingFloor>();
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

    public void addFloor(ParkingFloor floor)
    {
        floors.add(floor);
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public void setDisplayBoard(DisplayBoard displayBoard) {
        this.displayBoard = displayBoard;
    }
}
