package com.demo.dto.account;

import com.demo.dto.*;

public class Admin extends Account{
    ParkingLot parkingLot= ParkingLot.getInstance();

    public void addEntrancePanel(EntrancePanel entrancePanel)
    {
        // we have the same function in parking lot. Is it right?
        parkingLot.addEntrancePanel(entrancePanel);
    }
    public void addExitPanel(ExitPanel exitPanel)
    {
        parkingLot.addExitPanel(exitPanel);
    }

    public void addFloor(ParkingFloor floor)
    {
        parkingLot.addFloor(floor);
    }
}
