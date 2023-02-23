package com.demo.interfaces;

import com.demo.dto.parkingSpot.*;

public interface ParkingLotService {
    public boolean checkSpot(String spot);
    public ParkingSpot getParkingSpot(String spot);
    public void addFreeParkingSpot(ParkingSpot parkingSpot);
}
