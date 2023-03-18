package com.demo.dto;

import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;

import java.util.*;

public class DisplayBoard {
    private static DisplayBoard displayBoard= null;
    private Map<ParkingSpotTypeEnum, Integer> freeSpotCounts;

    private DisplayBoard() {
        freeSpotCounts= new HashMap<ParkingSpotTypeEnum, Integer>();
    }

    public static DisplayBoard getInstance(){
        if(displayBoard==null){
            displayBoard= new DisplayBoard();
        }
        return displayBoard;
    }


    public Map<ParkingSpotTypeEnum, Integer> getFreeSpotCounts() {
        return freeSpotCounts;
    }
}
