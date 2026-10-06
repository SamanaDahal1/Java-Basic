package Java8Features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collector;

public class ComparatorUsingLambda {
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(89);
        list.add(19);
        list.add(34);
        list.add(20);
        list.add(62);
        Collections.sort(list,(a,b)->b-a);
        System.out.println(list);
    }
}
