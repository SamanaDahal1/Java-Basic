package HotelRoomBookingSystem;

public class StandardRoom extends Room{

    StandardRoom(int number, double basePricePerNight) {
        super(number, basePricePerNight);
    }

    @Override
    String getRoomType() {
        return "Standard";
    }

    @Override
    double calculatePrice(int night) {
        return getBasePricePerNight()*night;
    }
}
