package com.interfaces.miniproject.vehicleSystem;

public class Car implements IVehicleControl {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    public void changeGear(int gear) {
        System.out.println("Car gear changed to: " + gear);
    }
}
