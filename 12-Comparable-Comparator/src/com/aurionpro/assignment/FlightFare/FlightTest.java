package com.aurionpro.assignment.FlightFare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FlightTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<FlightModel> flights = new ArrayList<>();

//		flights.add( new FlightModel("AirX",  8500.00));
//		flights.add(new FlightModel("JetY",  6200.50));
//		flights.add(new FlightModel("SkyZ", 10200.75));
//		flights.add( new FlightModel("FlyQ",  7500.25));
		
		int n;
        while (true) {
            try {
                System.out.print("How many flights do you want to enter? ");
                n = scanner.nextInt();
                scanner.nextLine();            
                if (n <= 0) {
                    System.out.println("Enter a positive number.");
                    continue;
                }
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Numbers only, please.");
                scanner.nextLine();                // clear bad token
            }
        }

        /* enter each flight */
        for (int i = 1; i <= n; i++) {

            /* airline name */
            String airline;
            while (true) {
                System.out.print("Enter airline name for flight " + i + ": ");
                airline = scanner.nextLine().trim();
                if (airline.isEmpty()) {
                    System.out.println("Airline name cannot be empty.");
                } else {
                    break;
                }
            }

            /* fare */
            double fare;
            while (true) {
                try {
                    System.out.print("Enter fare for " + airline + ": ");
                    fare = scanner.nextDouble();
                    scanner.nextLine();            // flush newline
                    if (fare <= 0) {
                        System.out.println("Fare must be positive.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Fare must be a number.");
                    scanner.nextLine();
                }
            }

            flights.add(new FlightModel(airline, fare));
        }
        
		Collections.sort(flights, new FlightFareDescComparator());

        System.out.println("Flights sorted by fare (desc):");
        System.out.println(flights);
        
        scanner.close();
	}
}
