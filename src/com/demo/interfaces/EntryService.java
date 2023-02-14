package com.demo.interfaces;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;

public interface EntryService {
    public ParkingTicket createParkingTicket();
    public ParkingSpot findParkingSpot();
}
