package com.demo.interfaces;

import com.demo.dto.parkingSpot.*;
import com.demo.exceptions.*;

public interface ParkingLotService {
    public ParkingSpot getParkingSpot(String spot) throws SpotNotFoundException;
    public void addFreeParkingSpot(ParkingSpot parkingSpot);
}
