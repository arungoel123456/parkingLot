package com.demo.dto.vehicle;

import java.util.*;
import java.util.concurrent.atomic.*;

public abstract class Vehicle {
    private static final AtomicInteger x = new AtomicInteger(0);
    private int id;

    public Vehicle() {
        this.id = x.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
