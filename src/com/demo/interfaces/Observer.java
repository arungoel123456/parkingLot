package com.demo.interfaces;

import com.demo.dto.*;

public interface Observer {
    public void update(ParkingEvent event);
}
