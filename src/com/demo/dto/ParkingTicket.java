package com.demo.dto;

import com.demo.dto.parkingSpot.*;
import com.demo.dto.vehicle.*;

import java.util.*;
import java.util.concurrent.atomic.*;

public class ParkingTicket {

    private static AtomicInteger ID_GENERATOR;
    private String id;
    private Vehicle vehicle;
    private Date timestamp;
    private ParkingSpot parkingSpot;

    public ParkingTicket(Vehicle vehicle, Date timestamp, ParkingSpot parkingSpot) {
        this.id = String.valueOf(ID_GENERATOR.getAndIncrement());
        this.vehicle = vehicle;
        this.timestamp = timestamp;
        this.parkingSpot= parkingSpot;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getParkingHours(){
        long milliseconds= System.currentTimeMillis() - timestamp.getTime();
        return (int) ((milliseconds / (1000*60*60)) % 24);
    }
}
