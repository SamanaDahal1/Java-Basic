package CoreJavaRevision.VehicleRentalSystem;

abstract class Vehicle {
    private int vehicleId;
    private String brand;
    private double pricePerDay;
    Vehicle(int vehicleId,String brand,double pricePerDay){
        this.vehicleId=vehicleId;
        this.brand=brand;
        this.pricePerDay=pricePerDay;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    abstract double calculateRent(int day);
    void displayInfo(){
        System.out.println("Vehicle Id: "+vehicleId+"\nBrand: "+brand+"\nPrice Per Day: "+pricePerDay+"\n");
    }

}
