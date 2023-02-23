package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.dto.vehicle.*;
import com.demo.interfaces.*;

public class ExitServiceImpl implements ExitService {
    ParkingLotService parkingLotService;
    @Override
    public void validateParkingTicket(Vehicle vehicle, ParkingTicket parkingTicket) {
        if(parkingTicket.getVehicle().equals(vehicle))
        {
            ParkingSpot parkingSpot= parkingTicket.getParkingSpot();
            parkingSpot.setFree(true);
            parkingLotService.addFreeParkingSpot(parkingSpot);
            // call payment service and get money
        }
    }

}
