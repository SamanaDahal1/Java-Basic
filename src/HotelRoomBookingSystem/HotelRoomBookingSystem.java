package HotelRoomBookingSystem;

import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

public class HotelRoomBookingSystem {
    public static void main(String[] args) throws RoomNotAvailableException, InvalidDateRangeException, BookingNotFoundException {
        HotelService service = new HotelService();
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("\n----Hotel Room Booking System----\n");
            System.out.println("(Enter 1-10)\n" +
                    "1,Add a room\n" +
                    "2.Register a guest\n" +
                    "3.Search available rooms\n" +
                    "4.Book a room\n" +
                    "5.Cancel a booking\n" +
                    "6.View bookings by guest\n" +
                    "7.Check room occupancy\n" +
                    "8.View revenue by room type\n" +
                    "9.View the most-booked room\n" +
                    "10.Exit");
            System.out.println("-------------------------------------");
            int numChoice = s.nextInt();
            if (numChoice == 1) {
                System.out.println("-------Add Room-------\n");
                System.out.print("Enter Room Number: ");
                int roomNumber = s.nextInt();
                System.out.print("Enter Room type:\n" +
                        "1.Standard\n" +
                        "2.Deluxe\n" +
                        "3.Suite\n");
                int roomType = s.nextInt();
                System.out.print("Enter base price per night: ");
                int basePricePerNight = s.nextInt();
                if (roomType == 1) {
                    service.addRoom(new StandardRoom(roomNumber, basePricePerNight));
                } else if (roomType == 2) {
                    service.addRoom(new DeluxeRoom(roomNumber, basePricePerNight));
                } else if (roomType == 3) {
                    service.addRoom(new SuiteRoom(roomNumber, basePricePerNight));
                } else {
                    System.out.println("Invalid Input.Please Enter 1 or 2 or 3");
                }
                System.out.println("Room Added successfully");
                System.out.println("-------------------------------------");
            } else if (numChoice == 2) {
                System.out.println("-----Register Guest-----\n");
                System.out.print("Enter Guest Id: ");
                int guestId = s.nextInt();
                s.nextLine();
                System.out.print("Enter Guest Name: ");
                String guestName = s.nextLine();
                System.out.print("Enter Guest Phone Number: ");
                String guestPhoneNum = s.next();
                service.registerGuest(new Guest(guestId, guestName, guestPhoneNum));
                System.out.println("-------------------------------------");
            } else if (numChoice == 3) {
                System.out.println("-----Search Available Room-----\n");
                System.out.print("Enter Check In date: (yyyy-MM-dd): ");
                String userCheckInDate = s.next();
                DateTimeFormatter dateTimeFormatterIn = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate checkInDate = LocalDate.parse(userCheckInDate, dateTimeFormatterIn);
                System.out.print("Enter Check Out date: (yyyy-MM-dd): ");
                String userCheckOutDate = s.next();
                DateTimeFormatter dateTimeFormatterOut = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate checkOutDate = LocalDate.parse(userCheckOutDate, dateTimeFormatterOut);
                System.out.print("Enter Room type:\n" +
                        "Standard\n" +
                        "Deluxe\n" +
                        "Suite\n");
                String roomType = s.next();
                System.out.print("Enter price: ");
                double price = s.nextDouble();
                List<Room> availableRooms = service.searchAvailableRooms(checkInDate, checkOutDate, roomType, price);
                if (availableRooms.isEmpty()) {
                    System.out.println("No rooms available matching your criteria");
                } else {
                    for (Room room : availableRooms) {
                        System.out.println(room.getNumber() + "\n" + room.getRoomType() + "\n" + room.getBasePricePerNight());
                        System.out.println("-------------------------------------");
                    }
                }
            } else if (numChoice == 4) {
                System.out.println("-----Book a Room-----");
                System.out.println("Enter Booking Id: ");
                int bookingId = s.nextInt();
                System.out.println("Enter Guest Id: ");
                int guestId = s.nextInt();
                System.out.println("Enter Room Number: ");
                int roomNumber = s.nextInt();
                System.out.print("Enter Check In date:(yyyy-MM-dd): ");
                String userCheckInDate = s.next();
                DateTimeFormatter dateTimeFormatterIn = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate checkInDate = LocalDate.parse(userCheckInDate, dateTimeFormatterIn);
                System.out.print("Enter Check Out date:(yyyy-MM-dd): ");
                String userCheckOutDate = s.next();
                DateTimeFormatter dateTimeFormatterOut = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate checkOutDate = LocalDate.parse(userCheckOutDate, dateTimeFormatterOut);
                Guest guest = service.storeGuests.get(guestId);
                Room room = service.getRoomByNumber(roomNumber);
                if (guest == null || room == null) {
                    System.out.println("Not Found");
                } else {
                    try {
                        Booking booking = new Booking(bookingId, guest, room, checkInDate, checkOutDate);
                        service.addBooking(booking);
                        System.out.println("Booked Successfully");
                        System.out.println("-------------------------------------");
                    } catch (InvalidDateRangeException e) {
                        System.out.println("Invalid Date Range.Checkout must be after check in");
                    } catch (RoomNotAvailableException e) {
                        System.out.println("Room is not available for these dates");
                    }
                }
            } else if (numChoice == 5) {
                System.out.print("Enter booking Id: ");
                int bookingId = s.nextInt();
                LocalDateTime cancellationTime = LocalDateTime.now();
                try {
                    double cancel = service.cancelBooking(bookingId, cancellationTime);
                    System.out.println("Booking Cancelled Successfully");
                    System.out.println("Cancellation penalty: " + cancel);
                    System.out.println("-------------------------------------");
                } catch (BookingNotFoundException e) {
                    System.out.println("Booking of this id doesnt exist.Check Booking id");
                }
            } else if (numChoice == 6) {
                System.out.println("-----View bookings by guest-----\n");
                System.out.println("Enter guest Id: ");
                int guestId = s.nextInt();
                List<Booking> bookings = service.getBookingByGuest(guestId);

                if (bookings.isEmpty()) {
                    System.out.println("No Booking found");
                } else {
                    for (Booking booking : bookings) {
                        System.out.println("Booking Id: " + booking.getId() + "\nRoom Number: " + booking.getRoom().getNumber() + "\nCheck in: " + booking.getCheckIn() + "\nCheck out: " + booking.getCheckOut());
                        System.out.println("-------------------------------------");
                    }
                }
            } else if (numChoice == 7) {
                System.out.println("-----Check room occupancy-----\n");
                System.out.println("Enter room number: ");
                int roomNum = s.nextInt();
                String userCheckInDate = s.next();
                DateTimeFormatter dateTimeFormatterIn = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate checkDate = LocalDate.parse(userCheckInDate, dateTimeFormatterIn);
                if (service.isRoomOccupied(roomNum, checkDate)) {
                    System.out.println("Occupied on these dates");

                } else {
                    System.out.println("Room Available for these dates");
                }
                System.out.println("-------------------------------------");
            } else if (numChoice == 8) {
                System.out.println("-----View revenue by room type-----\n");
                Map<String, Double> revenue = service.calculateRevenueByRoomType();
                if (revenue.isEmpty()) {
                    System.out.println("No revenue recorded yet");
                } else {
                    for (Map.Entry<String, Double> room : revenue.entrySet()) {
                        System.out.println("Room Type: " + room.getKey() + "\nRoom Revenue: " + room.getValue());
                    }
                }
                System.out.println("-------------------------------------");
            } else if (numChoice == 9) {
                System.out.println("-----View most booked room-----\n");
                Optional<Room> findMost = service.findMostBookedRoom();
                findMost.ifPresentOrElse(room -> System.out.println("Mosted Booked Room :" + room.getNumber() + " " + room.getRoomType()), () -> System.out.println("No booking found yet"));
                System.out.println("-------------------------------------");
            }
            else if (numChoice==10) {
                System.out.println("Thanks for using Hotel Management System");
                System.exit(0);
            }
        }
    }
}

