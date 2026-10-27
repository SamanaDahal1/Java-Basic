package CoreJavaRevision.VehicleRentalSystem;

public class Bike extends Vehicle{
    private int engineCC;
    Bike(int vehicleId, String brand, double pricePerDay,int engineCC) {
        super(vehicleId, brand, pricePerDay);
        this.engineCC=engineCC;
    }

    public int getEngineCC() {
        return engineCC;
    }

    @Override
    double calculateRent(int day) {
        if(day<=7){
           return getPricePerDay()*day;
        }
        else {
            return ((getPricePerDay()*day)-(0.10*getPricePerDay()*day));
        }
    }
}
