package com.demo.dto.parkingSpot.electric;

import com.demo.dto.parkingSpot.*;
import com.demo.enums.*;

public class Electric extends ParkingSpot {
    private ElectricPanel electricPanel;

    public ElectricPanel getElectricPanel() {
        return electricPanel;
    }

    public void setElectricPanel(ElectricPanel electricPanel) {
        this.electricPanel = electricPanel;
    }
}
