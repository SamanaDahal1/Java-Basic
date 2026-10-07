package Java8Features;

import java.util.function.BiPredicate;

public class BIPredicateQuestion {
    public static void main(String[] args){
        BiPredicate<Integer,Integer> here = (x,y)->x%2==0 && y%5==0;
        System.out.println( here.test(21,70));
    }
}
