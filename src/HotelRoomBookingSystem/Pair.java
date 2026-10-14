package HotelRoomBookingSystem;

public class Pair <A,B>{
    private A room ;
    private B amount;

    Pair(A room, B amount){
        this.room=room;
        this.amount=amount;
    }

    public A getRoom() {
        return room;
    }

    public B getAmount() {
        return amount;
    }
}
