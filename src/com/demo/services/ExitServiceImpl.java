package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.dto.vehicle.*;
import com.demo.interfaces.*;

public class ExitServiceImpl implements ExitService {
    DisplayService displayService;
    @Override
    public void validateParkingTicket(Vehicle vehicle, ParkingTicket parkingTicket) {
        if(parkingTicket.getVehicle().equals(vehicle))
        {
            freeParkingSpot(parkingTicket.getParkingSpot());
            // call payment service and get money
        }
    }

    private void freeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.setFree(true);
        displayService.addFreeParkingSpot(parkingSpot);
    }
}
