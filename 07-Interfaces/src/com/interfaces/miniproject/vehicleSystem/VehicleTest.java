package com.interfaces.miniproject.vehicleSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VehicleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IVehicleControl[] vehicles = { new Car(), new Bike(), new Truck() };
        final int MAX_GEAR = 6;

        while (true) {
            System.out.println("\nChoose Vehicle:");
            System.out.println("1) Car");
            System.out.println("2) Bike");
            System.out.println("3) Truck");
            System.out.println("0) Exit");
            System.out.print("Your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Numbers only, please.");
                scanner.nextLine();
                continue;
            }

            if (choice == 0) break;
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid option. Try again.");
                continue;
            }

            IVehicleControl v = vehicles[choice - 1];
            System.out.println("Vehicle: " + v.getClass().getSimpleName());
            v.start();

            while (true) {
                try {
                    System.out.print("Enter gear to shift to (1-" + MAX_GEAR + "): ");
                    int gear = scanner.nextInt();
                    if (gear < 1 || gear > MAX_GEAR)
                        throw new IllegalArgumentException("Gear must be between 1 and " + MAX_GEAR + ".");
                    v.changeGear(gear);
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input: numbers only.");
                    scanner.nextLine();
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            v.stop();
            System.out.println("----------------------");
        }

        scanner.close();
    }
}
