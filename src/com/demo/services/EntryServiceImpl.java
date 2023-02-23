package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.dto.vehicle.*;
import com.demo.interfaces.*;

import java.util.*;

public class EntryServiceImpl implements EntryService {
    ParkingLotService parkingLotService;
    @Override
    public ParkingTicket createParkingTicket(Vehicle vehicle) {

        // need to fetch parking spot type here.
        ParkingSpot parkingSpot= parkingLotService.getParkingSpot("compact");
        if(parkingSpot== null){
            System.out.println("There is no parking spot");
        }
        if (parkingSpot.isFree()) {
            synchronized (parkingSpot) {
                if (parkingSpot.isFree()) {
                    parkingSpot.setFree(false);
                    ParkingTicket parkingTicket= new ParkingTicket(vehicle, new Date(), parkingSpot);
                    // updateDisplayService()
                    return parkingTicket;
                }
            }
        }
        return null;
//        throw new Exception("Parking spot not available");
    }
}
