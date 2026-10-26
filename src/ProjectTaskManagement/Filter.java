package ProjectTaskManagement;

import java.util.function.Predicate;

public class Filter<T> {
    public static <T> Predicate<T> all(Predicate<T>... predicates){
        Predicate<T> combine = t -> true;
        for(int i =0 ; i< predicates.length;i++){
            combine=combine.and(predicates[i]);
        }
        return combine;
    }
    public  static  <T> Predicate<T> any(Predicate<T>... predicates){
        Predicate<T> combine = t -> false;
        for(int i =0 ; i< predicates.length;i++){
            combine=combine.or(predicates[i]);
        }
        return combine;
    }
    public  static  <T> Predicate<T> not(Predicate<T> predicate){
        Predicate<T> combine =predicate.negate();
        return combine;
    }
}
