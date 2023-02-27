package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.dto.vehicle.*;
import com.demo.enums.*;
import com.demo.exceptions.*;
import com.demo.interfaces.*;
import com.demo.interfaces.Observer;

import java.util.*;

public class ParkingServiceImpl {
    private ParkingLot parkingLot;
    private List<Observer> observers;
    private PaymentService paymentService;

    public ParkingServiceImpl(){
        observers= new ArrayList<Observer>();
        paymentService= new PaymentServiceImpl();
        parkingLot= ParkingLot.getInstance();
    }

    public ParkingTicket createParkingTicket(Vehicle vehicle) throws SpotNotFoundException {
        ParkingTypeEnum parkingTypeEnum= getParkingSpotType(vehicle);
        HashSet<ParkingSpot> freeParkingSpots= parkingLot.getFreeParkingSpots().get(parkingTypeEnum);
        if(freeParkingSpots.isEmpty()){
            throw new SpotNotFoundException("Spot not found");
        }

        HashSet<ParkingSpot> occupiedParkingSpots= parkingLot.getOccupiedParkingSpots().get(parkingTypeEnum);
        ParkingSpot parkingSpot= freeParkingSpots.iterator().next();

        try{
            if (parkingSpot.isFree()) {
                synchronized (parkingSpot) {
                    if (parkingSpot.isFree()) {
                        parkingSpot.setFree(false);
                        occupiedParkingSpots.add(parkingSpot);
                        ParkingTicket parkingTicket= new ParkingTicket(vehicle, new Date(), parkingSpot);
                        notifyAllObservers(-1);
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

    private void notifyAllObservers(int event)
    {
        for(Observer observer: observers){
            observer.update(event);
        }
    }

    public void validateParkingTicket(Vehicle vehicle, ParkingTicket parkingTicket) throws InvalidTicketException {
        if(parkingTicket.getVehicle().equals(vehicle))
        {
            paymentService.acceptPayment(parkingTicket);
            ParkingSpot parkingSpot= parkingTicket.getParkingSpot();
            parkingSpot.setFree(true);
            parkingLot.getFreeParkingSpots().get(parkingSpot.getParkingTypeEnum()).add(parkingSpot);
            parkingLot.getOccupiedParkingSpots().get(parkingSpot.getParkingTypeEnum()).remove(parkingSpot);
            notifyAllObservers(-1);
        }
        else
        {
            throw new InvalidTicketException("This is an invalid ticket");
        }
    }

    public ParkingTypeEnum getParkingSpotType(Vehicle vehicle){
        if( vehicle instanceof Car){
            return ParkingTypeEnum.COMPACT;
        }
        else if(vehicle instanceof Truck){
            return ParkingTypeEnum.ELECTRIC;
        }
        else if(vehicle instanceof Truck){
            return ParkingTypeEnum.LARGE;
        }
        return null;
    }
}
