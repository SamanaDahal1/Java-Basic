package HotelRoomBookingSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HotelService {
    Map<Integer, Room> storeRoom = new HashMap<>();
    Map<Integer, List<Booking>> storesBookings = new HashMap<>();
    Map<Integer, Queue<WaitingRequest>> storesWaitingRequest = new HashMap<>();
    Set<Integer> storesGuestId = new HashSet<>();
    Map<Integer, Guest> storeGuests = new HashMap<>();

    void addRoom(Room room) {
        storeRoom.put(room.getNumber(), room);
        storesBookings.put(room.getNumber(), new ArrayList<>());
        storesWaitingRequest.put((room.getNumber()), new LinkedList<>());

    }

    void registerGuest(Guest guest) {
        int beforeSize = storesGuestId.size();
        storesGuestId.add(guest.getId());
        if (beforeSize < storesGuestId.size()) {
            storeGuests.put(guest.getId(), guest);
            System.out.println("Guest registered successfully");
        } else {
            System.out.println("Guest Id already exist");
        }
    }

    void validateDateRange(Booking booking) throws InvalidDateRangeException {
        if (!booking.getCheckIn().isBefore(booking.getCheckOut())) {
            throw new InvalidDateRangeException("Invalid Date Range");
        }
    }

    long calculateNights(Booking booking) {
        return ChronoUnit.DAYS.between(booking.getCheckIn(), booking.getCheckOut());
    }

    double calculateBookingPrice(Booking booking) {
        double price = booking.getRoom().calculatePrice((int) (calculateNights(booking)));
        return price;

    }

    boolean isRoomAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
        int num = room.getNumber();
        List<Booking> bookings = storesBookings.get(num);
        for (Booking booking : bookings) {
            if (checkIn.isBefore(booking.getCheckOut()) && checkOut.isAfter(booking.getCheckIn())) {
                return false;
            }
        }
        return true;
    }

    List<Room> findAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        List<Room> checkRoom = new ArrayList<>();
        for (Room rooms : storeRoom.values()) {
            if (isRoomAvailable(rooms, checkIn, checkOut)) {
                checkRoom.add(rooms);
            }

        }
        return checkRoom;
    }

    Room getRoomByNumber(int roomNumber) {
        Room room = storeRoom.get(roomNumber);
        if (room != null) {
            return room;
        } else {
            return null;
        }

    }

    void addBooking(Booking booking) throws RoomNotAvailableException, InvalidDateRangeException {
        validateDateRange(booking);
        Room room = getRoomByNumber(booking.getRoom().getNumber());
        if (room == null) {
            throw new RoomNotAvailableException("Room does not exist");
        }
        if (!isRoomAvailable(room, booking.getCheckIn(), booking.getCheckOut())) {
            throw new RoomNotAvailableException("Room is not available for the selected dates");
        }
        storesBookings.get(room.getNumber()).add(booking);
    }

    double cancelBooking(int bookingId, LocalDateTime cancellationTime) throws BookingNotFoundException {
        for (List<Booking> bookings : storesBookings.values()) {
            Iterator<Booking> iterator = bookings.iterator();
            while (iterator.hasNext()) {
                Booking booking = iterator.next();
                if (booking.getId() == bookingId) {
                    int roomNumber = booking.getRoom().getNumber();
                    double penalty = booking.calculateCancellationPending(cancellationTime);
                    iterator.remove();
                    processWaitingList(roomNumber);
                    return penalty;
                }
            }
        }
        throw new BookingNotFoundException("Booking not found");
    }

    void processWaitingList(int roomNumber) {
        Queue<WaitingRequest> roomNum = storesWaitingRequest.get(roomNumber);
        if (roomNum == null || roomNum.isEmpty()) {
            return;
        }
        Room room = storeRoom.get(roomNumber);
        Iterator<WaitingRequest> iterator = roomNum.iterator();
        while (iterator.hasNext()) {
            WaitingRequest waitingRequest = iterator.next();
            if (isRoomAvailable(room, waitingRequest.getCheckIn(), waitingRequest.getCheckOut())) {
                System.out.println("Room available: " + waitingRequest.getGuest().getName());
                iterator.remove();
                return;
            }
        }

    }

    List<Booking> getBookingByGuest(int guestId) {
        List<Booking> storeMatch = new ArrayList<>();
        for (List<Booking> bookings : storesBookings.values()) {
            for (Booking booking : bookings) {
                if (booking.getGuest().getId() == guestId) {
                    storeMatch.add(booking);
                }
            }
        }
        storeMatch.sort(Comparator.comparing(Booking::getCheckIn));
        return storeMatch;
    }

    List<Room> searchAvailableRooms(LocalDate checkIn, LocalDate checkOut, String roomType, double maxPrice) {
        List<Room> searchRoom = new ArrayList<>();
        for (Room rooms : storeRoom.values()) {
            if (isRoomAvailable(rooms, checkIn, checkOut)) {
                if (roomType.equalsIgnoreCase(rooms.getRoomType())) {
                    if (maxPrice >= rooms.calculatePrice(1)) {
                        searchRoom.add(rooms);
                    }
                }

            }
        }
        return searchRoom;
    }

//    Optional<Room> findCheapestRoom(LocalDate checkIn, LocalDate checkOut) {
//        List<Room> availableRoom = findAvailableRooms(checkIn, checkOut);
//        Optional<Room> cheapestRoom = availableRoom.stream()
//                .min(Comparator.comparingDouble(room -> room.calculatePrice(1)));
//
//
//        return cheapestRoom;
//
//    }

    Map<String, Double> calculateRevenueByRoomType() {
        Map<String, Double> revenueByRoomType = new HashMap<>();
        for (List<Booking> bookings : storesBookings.values()) {
            for (Booking booking : bookings) {
                String roomType = booking.getRoom().getRoomType();
                double price = calculateBookingPrice(booking);
                revenueByRoomType.merge(roomType, price, Double::sum);
            }

        }
        return revenueByRoomType;
    }

    Optional<Room> findMostBookedRoom() {
        int maxBooking = 0;
        Room mostBookedRoom = null;
        for (Map.Entry<Integer, List<Booking>> checking : storesBookings.entrySet()) {
            int bookingCount = checking.getValue().size();
            if (bookingCount > maxBooking) {
                maxBooking = bookingCount;
                mostBookedRoom = storeRoom.get(checking.getKey());
            }
        }
        return Optional.ofNullable(mostBookedRoom);

    }

    boolean isRoomOccupied(int roomNumber, LocalDate date) {
        for (Booking booking : storesBookings.get(roomNumber)) {
            if (date.isBefore(booking.getCheckOut()) && (date.isAfter(booking.getCheckIn()) || date.isEqual(booking.getCheckIn()))) {
                return true;
            }
        }
        return false;
    }
//    void addToWaitingList(int roomNumber,Guest guest,LocalDate checkIn,LocalDate checkOut) {
//
//        Room room  = getRoomByNumber(roomNumber) ;
//        if(room==null) {
//            System.out.println("Room Number doesnt exist");
//            return;
//        }
//        if(!isRoomAvailable(room,checkIn,checkOut)){
//            WaitingRequest waitingRequest = new WaitingRequest(guest,checkIn,checkOut);
//            storesWaitingRequest.get(roomNumber).offer(waitingRequest);
//
//        }
//}
    }



