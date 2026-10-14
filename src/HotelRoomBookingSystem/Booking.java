package HotelRoomBookingSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Booking implements Cancellable {
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

    @Override
    public double calculateCancellationPending(LocalDateTime dateTime) {
        LocalDateTime time = getCheckIn().atStartOfDay();
        long hours =ChronoUnit.HOURS.between(dateTime,time);
        if(hours<24 && hours>=0){
            return room.getBasePricePerNight();
        }
        else {
            return 0;
        }

    }
}
