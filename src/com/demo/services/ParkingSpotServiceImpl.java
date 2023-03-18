package com.demo.services;

import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;

import java.lang.reflect.*;
import java.util.*;

public class ParkingSpotServiceImpl {


    public ParkingSpotServiceImpl() {

    }

    public ParkingSpot createParkingSpot(ParkingSpotTypeEnum parkingSpotTypeEnum, Integer floorNumber){
        try {
            return (ParkingSpot) parkingSpotTypeEnum.getC().getConstructor(Integer.class).newInstance(floorNumber);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
