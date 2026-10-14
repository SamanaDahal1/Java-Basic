package HotelRoomBookingSystem;

public abstract class Room {
    private int number;
    private double basePricePerNight;

    abstract double calculatePrice(int night);

   Room(int number,double basePricePerNight){
        this.number=number;
        this.basePricePerNight=basePricePerNight;
   }

    public int getNumber() {
        return number;
    }

    public double getBasePricePerNight() {
        return basePricePerNight;
    }
    abstract String getRoomType();
}
