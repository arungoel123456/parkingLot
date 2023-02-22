package com.demo.interfaces;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.dto.vehicle.*;

public interface EntryService {
    public ParkingTicket createParkingTicket(Vehicle vehicle);
}
