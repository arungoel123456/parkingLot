package com.demo.dto.parkingSpot;

public abstract class ParkingSpot {
    private String id;
    private boolean isFree;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
