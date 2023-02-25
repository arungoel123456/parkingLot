package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.dto.vehicle.*;
import com.demo.exceptions.*;
import com.demo.interfaces.*;

import java.util.*;

public class ParkingService {
    ParkingLot parkingLot= ParkingLot.getInstance();


    public ParkingTicket createParkingTicket(Vehicle vehicle) throws SpotNotFoundException {
        try{
            // need to fetch parking spot type here.
            ParkingSpot parkingSpot= getParkingSpot("compact");
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
                    else {
                        return createParkingTicket(vehicle);
                    }
                }
            }
        }
        catch (SpotNotFoundException spotNotFoundException){
            System.out.println(spotNotFoundException.getMessage());
        }
        // Is returning null important??
        return null;
    }
    public void validateParkingTicket(Vehicle vehicle, ParkingTicket parkingTicket) {
        if(parkingTicket.getVehicle().equals(vehicle))
        {
            ParkingSpot parkingSpot= parkingTicket.getParkingSpot();
            parkingSpot.setFree(true);
            addFreeParkingSpot(parkingSpot);
            // call payment service and get money
        }
    }

    public ParkingSpot getParkingSpot(String spot) throws SpotNotFoundException {
        HashSet<ParkingSpot> freeParkingSpots= parkingLot.getFreeParkingSpots().get(spot);
        HashSet<ParkingSpot> occupiedParkingSpots= parkingLot.getOccupiedParkingSpots().get(spot);

        if(freeParkingSpots.size() > 0){
            ParkingSpot parkingSpot= freeParkingSpots.iterator().next();
            freeParkingSpots.remove(parkingSpot);
            occupiedParkingSpots.add(parkingSpot);
            return parkingSpot;
        }
        else {
            throw new SpotNotFoundException("Spot not found");
        }
    }

    public void addFreeParkingSpot(ParkingSpot parkingSpot) {
        String parkingSpotType= getParkingSpotType(parkingSpot);
        parkingLot.getFreeParkingSpots().get(parkingSpotType).add(parkingSpot);
        parkingLot.getOccupiedParkingSpots().get(parkingSpotType).remove(parkingSpot);
    }

    public String getParkingSpotType(ParkingSpot parkingSpot){
        if( parkingSpot instanceof Compact){
            return "compact";
        }
        else if(parkingSpot instanceof Electric){
            return "electric";
        }
        else if(parkingSpot instanceof Large){
            return "large";
        }
        return "";
    }
}
