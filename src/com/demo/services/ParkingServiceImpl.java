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

    public ParkingTicket entry(Vehicle vehicle) throws SpotNotFoundException, ParkingSpotTypeNotFound {

        // is this ok?? Because this is having 2 different throws
        ParkingSpotTypeEnum parkingSpotTypeEnum = vehicle.getSupportedParkingSpotEnum();
        System.out.println("parkingSpotTypeEnum: " + parkingSpotTypeEnum);

        try {
            ParkingSpot parkingSpot= parkingStrategy.findParkingSpot(parkingSpotTypeEnum);
            System.out.println("parkingSpot: "+ parkingSpot);
            List<ParkingSpot> freeParkingSpots= parkingLot.getFreeParkingSpots().get(parkingSpotTypeEnum);
            List<ParkingSpot> occupiedParkingSpots= parkingLot.getOccupiedParkingSpots().get(parkingSpotTypeEnum);

//            System.out.println(freeParkingSpots);
//            System.out.println(occupiedParkingSpots);


            if (parkingSpot.isFree()) {
                synchronized (parkingSpot) {
                    if (parkingSpot.isFree()) {
                        parkingSpot.setFree(false);
                        freeParkingSpots.remove(parkingSpot);
                        occupiedParkingSpots.add(parkingSpot);
                        ParkingTicket parkingTicket= new ParkingTicket(vehicle, new Date(), parkingSpot); // date should be local date time
                        notifyAllObservers( new ParkingEvent(ParkingEventType.ENTRY , parkingSpotTypeEnum) );

//                        System.out.println(freeParkingSpots);
//                        System.out.println(occupiedParkingSpots);

                        return parkingTicket;
                    }
                    else {
                        return entry(vehicle);
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
    public void addWash(ParkingTicket parkingTicket){
        parkingTicket.setParkingSpot(  new Wash( parkingTicket.getParkingSpot() ));
    }

    public void addElectricCharge(ParkingTicket parkingTicket){
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

}
