package HotelRoomBookingSystem;

public class SuiteRoom extends Room{
    SuiteRoom(int number, double basePricePerNight) {
        super(number, basePricePerNight);
    }

    @Override
    double calculatePrice(int night) {
        double flatService=1000 ;
        return getBasePricePerNight()*night+ flatService;
    }
}
