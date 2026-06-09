package FuelRecharger;

import java.util.*;
public class MainFuel {
    public static void main(String[] args){
        Fuel f = new Fuel();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter current fuel: ");
        int fuel = sc.nextInt();

        System.out.print("Enter distance to travel (km): ");
        int distance = sc.nextInt();

        Fuel car = new Fuel(fuel, distance);

        System.out.print("Enter mileage (km/litre): ");
        car.setMileage(sc.nextInt());

        System.out.print("Enter additional fuel to add for travelling: ");
        car.putFuel(sc.nextInt());

        System.out.println("\nVehicle Details:");
        System.out.println(car);

        int possibleDistance = car.getFuelRemaining() * car.getMileage();

        System.out.println("Maximum possible distance: " + possibleDistance + " km");

        if (possibleDistance >= distance) {
            System.out.println("Fuel is sufficient");
        } else {
            System.out.println("Fuel is insufficient.");
            System.out.println("Need at least "
                    + (distance - possibleDistance)
                    + " more km worth of fuel.");
        }

        sc.close();
    }
}

