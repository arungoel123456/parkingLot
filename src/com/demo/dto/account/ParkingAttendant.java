package com.demo.dto.account;

import com.demo.interfaces.*;
import com.demo.parkingStrategy.*;
import com.demo.services.*;

public class ParkingAttendant extends Account{

    ParkingLotService parkingLotService= (ParkingLotService) new ParkingServiceImpl(new FarthestFirstStrategy());
    public void processTicket(){

    }
}
