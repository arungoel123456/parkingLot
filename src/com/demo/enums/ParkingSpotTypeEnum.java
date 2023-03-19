package com.demo.enums;

import com.demo.dto.parkingSpot.*;

public enum ParkingSpotTypeEnum {
    COMPACT(Compact.class),
    LARGE(Large.class),
    MINI(Mini.class),
    ;

    private Class c;
    ParkingSpotTypeEnum( Class c) {
        this.c= c;
    }

    public Class getC() {
        return c;
    }

}
