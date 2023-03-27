package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;

import java.lang.reflect.*;
import java.util.*;

public class ParkingSpotServiceImpl {
    DisplayServiceImpl displayService= new DisplayServiceImpl();

    public ParkingSpot createParkingSpot(ParkingSpotTypeEnum parkingSpotTypeEnum, Integer floorNumber){
        try {
            ParkingSpot parkingSpot= (ParkingSpot) parkingSpotTypeEnum.getParkingSpot().getConstructor(Integer.class).newInstance(floorNumber);
            System.out.println("Parking spot: " + parkingSpot + " " + parkingSpot.getParkingTypeEnum() + parkingSpot.getId());
            ParkingLot.getInstance().addParkingSpot(parkingSpot);
            displayService.addParkingSpot(parkingSpotTypeEnum);
            return parkingSpot;
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
