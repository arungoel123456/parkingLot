package com.demo.services;

import com.demo.dto.*;
import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;
import com.demo.interfaces.Observer;
import org.jetbrains.annotations.*;

import java.util.*;

public class DisplayServiceImpl implements Observer {
    private Map<ParkingSpotTypeEnum, Integer> freeSpotCounts= DisplayBoard.getInstance().getFreeSpotCounts();

    @Override
    public void update(@NotNull ParkingEvent event) {
        int count= 0;
        if(event.getType().equals(ParkingEventType.ENTRY))
        {
            count=-1;
        }
        else{
            count=1;
        }
        int newCount= freeSpotCounts.get(event.getParkingType());
        freeSpotCounts.put(event.getParkingType() , newCount + count);
    }

    public void addParkingSpot(ParkingSpotTypeEnum parkingSpotTypeEnum){
        Integer count= freeSpotCounts.get(parkingSpotTypeEnum);
        if(count==null){
            count=0;
        }
        freeSpotCounts.replace(parkingSpotTypeEnum, count+1);
    }
}
