package CoreJavaRevision.VehicleRentalSystem;

public class Car extends Vehicle implements Insurable {
    private int numberOfSeats;

    Car(int vehicleId, String brand, double pricePerDay,int numberOfSeats) {
        super(vehicleId, brand, pricePerDay);
        this.numberOfSeats=numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    double calculateRent(int day) {
        return getPricePerDay()*day;
    }

    @Override
    public double calculateInsurance(int days) {
        return 500*days;
    }
}
