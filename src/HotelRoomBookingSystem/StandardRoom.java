package HotelRoomBookingSystem;

public class StandardRoom extends Room{

    StandardRoom(int number, double basePricePerNight) {
        super(number, basePricePerNight);
    }

    @Override
    double calculatePrice(int night) {
        return getBasePricePerNight()*night;
    }
}
