package HotelRoomBookingSystem;

import java.time.LocalDate;

public class WaitingRequest {
    private Guest guest;
    private LocalDate checkIn;
    private LocalDate checkOut;

    WaitingRequest(Guest guest,LocalDate checkIn,LocalDate checkOut){
        this.guest=guest;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public Guest getGuest() {
        return guest;
    }
}
