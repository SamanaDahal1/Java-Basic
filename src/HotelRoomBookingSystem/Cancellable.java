package HotelRoomBookingSystem;

import java.time.LocalDateTime;

public interface Cancellable {
     double calculateCancellationPending(LocalDateTime dateTime);
}
