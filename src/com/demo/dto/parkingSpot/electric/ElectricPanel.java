package com.demo.dto.parkingSpot.electric;

import java.util.*;

public class ElectricPanel {
    private Date startTime;
    private double amountPerSecond;

    public void reset(){
        startTime= null;
    }
    public void start(){
        startTime= new Date();
    }

    public long finish(){
        return new Date().getTime() - startTime.getTime();
    }

}
