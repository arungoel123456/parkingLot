package com.demo.dto.account;

import com.demo.dto.*;

public class Admin extends Account{
    ParkingLot parkingLot= ParkingLot.getInstance();

    public void addEntrancePanel(EntrancePanel entrancePanel)
    {
        parkingLot.addEntrancePanel(entrancePanel);
    }
    public void addExitPanel(ExitPanel exitPanel)
    {
        parkingLot.addExitPanel(exitPanel);
    }
}
