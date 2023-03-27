package com.demo.enums;

import com.demo.dto.parkingSpot.*;

public enum ParkingSpotTypeEnum {
    COMPACT(Compact.class),
    LARGE(Large.class),
    MINI(Mini.class),
    ;

    private Class parkingSpot;
    ParkingSpotTypeEnum( Class parkingSpot) {
        this.parkingSpot= parkingSpot;
    }

    public Class getParkingSpot() {
        return parkingSpot;
    }

}
