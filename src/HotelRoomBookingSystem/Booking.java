package HotelRoomBookingSystem;

import java.time.LocalDate;

public class Booking {
    private int id;
    private Room room;
    private Guest guest;
    private LocalDate checkIn;
    private LocalDate checkOut;

    Booking(int id, Guest guest,Room room,LocalDate checkIn,LocalDate checkOut){
        this.id=id;
        this.guest=guest;
        this.room=room;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
    }

    public int getId() {
        return id;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

}
