package HotelRoomBookingSystem;

public class Guest {
    private int id ;
    private String phoneNumber;
    private String name;

    Guest(int id ,String name, String phoneNumber){
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
