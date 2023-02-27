package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.interfaces.Observer;

import java.util.*;

public class DisplayServiceImpl implements Observer {
    private DisplayBoard displayBoard= DisplayBoard.getInstance();
    @Override
    public void update(int event) {

        synchronized (displayBoard){
            displayBoard.setFreeParkingSpotCount(displayBoard.getFreeParkingSpotCount() + event );
            displayBoard.setOccupiedParkingSpotCount(displayBoard.getOccupiedParkingSpotCount() - event );
        }
    }
}
