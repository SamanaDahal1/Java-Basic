package HotelRoomBookingSystem;

import java.util.*;

public class HotelService {
    Map<Integer,Room> storeRoom = new HashMap<>();
    Map<Integer, List<Booking>> storesBookings = new HashMap<>();
    Map<Integer, Queue<WaitingRequest>> storesWaitingRequest= new HashMap<>();
    Set<Integer> storesGuestId = new HashSet<>();
}
