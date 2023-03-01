package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.dto.parkingSpot.spotDecorator.*;
import com.demo.dto.vehicle.*;
import com.demo.enums.*;
import com.demo.exceptions.*;
import com.demo.interfaces.*;
import com.demo.interfaces.Observer;
import com.demo.parkingStrategy.*;

import java.util.*;

public class ParkingServiceImpl {
    private ParkingLot parkingLot;
    private List<Observer> observers;
    private PaymentService paymentService;
    private Strategy parkingStrategy;

    public ParkingServiceImpl(Strategy strategy){
        observers= new ArrayList<Observer>();
        parkingLot= ParkingLot.getInstance();
        parkingStrategy= strategy;
    }

    public ParkingTicket createParkingTicket(Vehicle vehicle) throws SpotNotFoundException, ParkingSpotTypeNotFound {
        ParkingTypeEnum parkingTypeEnum= getParkingSpotType(vehicle);

        try {
            ParkingSpot parkingSpot= parkingStrategy.findParkingSpot(parkingTypeEnum);
            List<ParkingSpot> freeParkingSpots= parkingLot.getFreeParkingSpots().get(parkingTypeEnum);
            List<ParkingSpot> occupiedParkingSpots= parkingLot.getOccupiedParkingSpots().get(parkingTypeEnum);

            if (parkingSpot.isFree()) {
                synchronized (parkingSpot) {
                    if (parkingSpot.isFree()) {
                        parkingSpot.setFree(false);
                        freeParkingSpots.remove(parkingSpot);
                        occupiedParkingSpots.add(parkingSpot);
                        ParkingTicket parkingTicket= new ParkingTicket(vehicle, new Date(), parkingSpot);
                        notifyAllObservers( new ParkingEvent(ParkingEventType.ENTRY , parkingTypeEnum) );
                        return parkingTicket;
                    }
                    else {
                        return createParkingTicket(vehicle);
                    }
                }
            }
        }
        catch (SpotNotFoundException spotNotFoundException){
            throw spotNotFoundException;
        }
        return null;
    }

    private void notifyAllObservers(ParkingEvent event)
    {
        for(Observer observer: observers){
            observer.update(event);
        }
    }

    // how does these look
    private void addWash(ParkingTicket parkingTicket){
        parkingTicket.setParkingSpot(  new Wash( parkingTicket.getParkingSpot() ));
    }

    private void addElectricCharge(ParkingTicket parkingTicket){
        parkingTicket.setParkingSpot( new ElectricCharge( parkingTicket.getParkingSpot() ));
    }

    public void exit(Vehicle vehicle, ParkingTicket parkingTicket) throws InvalidTicketException {
        if(parkingTicket.getVehicle().equals(vehicle))
        {
            ParkingSpot parkingSpot= parkingTicket.getParkingSpot();
            double amountToPay= parkingSpot.cost( parkingTicket.getParkingHours() );
            // on what basis should we call which parking method??

            parkingSpot.setFree(true);
            parkingStrategy.addParkingSpot(parkingLot.getFreeParkingSpots().get(parkingSpot.getParkingTypeEnum()) , parkingSpot);
            parkingLot.getOccupiedParkingSpots().get(parkingSpot.getParkingTypeEnum()).remove(parkingSpot);
            notifyAllObservers(new ParkingEvent(ParkingEventType.EXIT , parkingTicket.getParkingSpot().getParkingTypeEnum()));
        }
        else
        {
            throw new InvalidTicketException("This is an invalid ticket");
        }
    }

    public ParkingTypeEnum getParkingSpotType(Vehicle vehicle) throws ParkingSpotTypeNotFound {
        if( vehicle instanceof Car){
            return ParkingTypeEnum.COMPACT;
        }
        else if(vehicle instanceof Truck){
            return ParkingTypeEnum.ELECTRIC;
        }
        else if(vehicle instanceof Truck){
            return ParkingTypeEnum.LARGE;
        }
        else {
            throw new ParkingSpotTypeNotFound("This type is spot is not available");
        }
    }
}
