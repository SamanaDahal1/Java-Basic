package RideConsoleSystem;

import java.util.Scanner;

abstract class Ride{
    double distance;
    double fuelCost ;
    double mileage;
    abstract void calculateFare(double distance);

}
class Bike extends Ride{
    void calculateFare(double distance){
        mileage=100;
        fuelCost=150;
        double perKm =fuelCost/mileage;
        this.distance=distance;
        double totalCost= perKm * distance;
        System.out.println("Total Cost : "+ totalCost);


    }
        }

class Sedan extends Ride{
    void calculateFare(double distance){
        mileage=150;
        fuelCost=150;
        double perKm =fuelCost/mileage;
        this.distance=distance;
        double totalCost= perKm * distance;
        System.out.println("Total Cost : "+ totalCost);


    }
}

class SUV extends Ride{
    void calculateFare(double distance){
        mileage=300;
        fuelCost=200;
        double perKm =fuelCost/mileage;
        this.distance=distance;
        double totalCost= perKm * distance;
        System.out.println("Total Cost : "+ totalCost);


    }
}

class Booking{
    String name;
    String rideType;
    Double distance;
    Ride ride;


    void detail() {

        Scanner src = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = src.nextLine();
        System.out.println("choose your ride type (Bike / Sedan /SUV: ");
        rideType = src.nextLine();
        System.out.println("Enter distance: ");
        distance = src.nextDouble();

        System.out.printf("Name: %s\nRide Type: %s\nDistance: %f\n\t",name,rideType,distance);




        if(rideType.equalsIgnoreCase("Bike")){
            ride= new Bike();


        }
        else if (rideType.equalsIgnoreCase("Sedan")) {
            ride = new Sedan();

        }
        else if (rideType.equalsIgnoreCase("SUV")) {
           ride = new SUV();


        }
        else {
            System.out.println("Invalid Ride Type input");
        }
        ride.calculateFare(distance);

    }
}

public class RideManagement {
    public static void main(String[] args){
        Booking booking = new Booking();
        booking.detail();


    }
}
