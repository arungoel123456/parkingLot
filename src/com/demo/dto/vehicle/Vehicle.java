package com.demo.dto.vehicle;

import com.demo.enums.*;

import java.util.*;
import java.util.concurrent.atomic.*;

public abstract class Vehicle {
    private static final AtomicInteger x = new AtomicInteger(0);
    private int id;
    private ParkingSpotTypeEnum supportedParkingSpotEnum;

    public Vehicle(ParkingSpotTypeEnum supportedParkingSpotEnum) {
        this.id = x.incrementAndGet();
        this.supportedParkingSpotEnum= supportedParkingSpotEnum;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public ParkingSpotTypeEnum getSupportedParkingSpotEnum() {
        return supportedParkingSpotEnum;
    }

}
