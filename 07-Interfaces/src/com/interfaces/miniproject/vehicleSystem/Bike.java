package com.interfaces.miniproject.vehicleSystem;

public class Bike implements IVehicleControl {
    @Override
    public void start() {
        System.out.println("Bike started");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped");
    }

    @Override
    public void changeGear(int gear) {
        System.out.println("Bike gear changed to: " + gear);
    }
}
