package HotelRoomBookingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CollectionUtils {
    static <T> List<T>  filter(List<T> list, Predicate<T> predicate){
        ArrayList<T> storeItem= new ArrayList<>();
        for(T item : list){
            if( predicate.test(item)){
                storeItem.add(item);
            }

        }
        return storeItem;
    }

}
