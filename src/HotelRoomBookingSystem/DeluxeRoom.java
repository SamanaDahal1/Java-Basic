package HotelRoomBookingSystem;

public class DeluxeRoom extends Room{
    DeluxeRoom(int number, double basePricePerNight) {
        super(number, basePricePerNight);
    }

    @Override
    double calculatePrice(int night) {
        return (((double) 120 /100)*getBasePricePerNight())*night;
    }
}
