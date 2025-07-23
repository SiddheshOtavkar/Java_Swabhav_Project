package com.interfaces.miniproject.vehicleSystem;

public class Truck implements IVehicleControl {
    @Override
    public void start() {
        System.out.println("Truck started");
    }

    @Override
    public void stop() {
        System.out.println("Truck stopped");
    }

    @Override
    public void changeGear(int gear) {
        System.out.println("Truck gear changed to: " + gear);
    }
}
