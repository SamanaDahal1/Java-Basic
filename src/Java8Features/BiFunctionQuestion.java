package Java8Features;

import java.util.function.BiFunction;

public class BiFunctionQuestion {
    public static void main(String[] args) {
        BiFunction<String,String,Integer> here = (x,y)->x.length()+ y.length();
        System.out.println(here.apply("SAM","Here"));
    }
}
