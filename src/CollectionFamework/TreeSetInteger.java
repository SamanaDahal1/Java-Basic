package CollectionFamework;

import java.util.TreeSet;

public class TreeSetInteger {
    public static void main(String[] args){
        TreeSet<Integer> a = new TreeSet<>();
        a.add(40);
        a.add(10);
        a.add(30);
        a.add(20);
        a.add(50);
        a.add(30);
        System.out.println(a);
        System.out.println(a.size());
        System.out.println(a.contains(30));
        System.out.println(a.first());
        System.out.println(a.last());
        a.remove(20);
        System.out.println(a);
    }
}
