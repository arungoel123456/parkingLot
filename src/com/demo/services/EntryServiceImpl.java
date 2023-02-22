package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.dto.vehicle.*;
import com.demo.interfaces.*;

import java.util.*;

public class EntryServiceImpl implements EntryService {
    DisplayService displayService;
    @Override
    public ParkingTicket createParkingTicket(Vehicle vehicle) {

        // need to fetch parking spot type here.
        ParkingSpot parkingSpot= displayService.getParkingSpot("compact");
        if(parkingSpot== null){
            System.out.println("There is no parking spot");
        }
        if (parkingSpot.getFree()) {
            synchronized (parkingSpot) {
                if (parkingSpot.getFree()) {
                    parkingSpot.setFree(false);
                    ParkingTicket parkingTicket= new ParkingTicket(vehicle, new Date(), parkingSpot);

                    return parkingTicket;
                }
            }
        }
        
        throw new Exception("Parking spot not available");
    }
}
