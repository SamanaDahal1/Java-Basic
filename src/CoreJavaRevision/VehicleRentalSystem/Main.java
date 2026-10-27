package CoreJavaRevision.VehicleRentalSystem;

public class Main {
    public static void main(String[] args) {
        RentalService rentalService = new RentalService();
        Car car = new Car(1,"BMW",80000,2);
        Bike bike = new Bike(2,"Harley Davidson",80000,600);
        rentalService.addVehicle(bike);
        rentalService.addVehicle(car);
        double carRent=rentalService.calculateRental(1,8);
        double bikeRent=rentalService.calculateRental(2,10);
        rentalService.displayAllVehicles();
        System.out.println("Car Rent: "+carRent+"\nBike Rent: "+bikeRent);
        double carInsurance =car.calculateInsurance(7);
        System.out.println("Car Insurance: "+carInsurance);


    }
}
