package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;
import com.demo.interfaces.Observer;

import java.util.*;

public class DisplayServiceImpl implements Observer {
    private DisplayBoard displayBoard= DisplayBoard.getInstance();
    @Override
    public void update(ParkingEvent event) {
        int count= 0;
        if(event.getType().equals(ParkingEventType.ENTRY))
        {
            count=-1;
        }
        else{
            count=1;
        }

        displayBoard.setFreeParkingSpotCount(displayBoard.getFreeParkingSpotCount() + count);
        displayBoard.setOccupiedParkingSpotCount(displayBoard.getOccupiedParkingSpotCount() - count);
    }
}
