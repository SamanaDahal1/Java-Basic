package CoreJavaRevision.VehicleRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class RentalService {
        List<Vehicle> vehicles = new ArrayList<>();
        void addVehicle(Vehicle vehicle){
            vehicles.add(vehicle);
        }
        void displayAllVehicles(){
            for(Vehicle vehicle: vehicles){
                vehicle.displayInfo();
            }
        }
        Vehicle findVehicleById(int id){
            for(Vehicle vehicle: vehicles){
                if(vehicle.getVehicleId()==id){
                   return vehicle;
                }
            }
            return null;
        }
        double calculateRental(int vehicleId,int days){
            Vehicle vehicle =findVehicleById(vehicleId);
            if(vehicle!=null){
                return vehicle.calculateRent(days);
            }
            return 0;
        }

}
