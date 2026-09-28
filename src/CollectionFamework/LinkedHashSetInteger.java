package CollectionFamework;

import java.util.LinkedHashSet;


public class LinkedHashSetInteger {
    public static void main(String[] args){
        LinkedHashSet<Integer> a = new LinkedHashSet<>();
        a.add(50);
        a.add(20);
        a.add(40);
        a.add(10);
        a.add(30);
        a.add(20);
        System.out.println(a);
        System.out.println(a.size());
        System.out.println(a.contains(40));
        a.remove(20);
        System.out.println(a);


    }
}
