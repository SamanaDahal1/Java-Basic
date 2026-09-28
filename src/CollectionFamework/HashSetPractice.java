package CollectionFamework;

import java.util.HashSet;

public class HashSetPractice {
    public static void main(String[] args){
        HashSet<Integer> a = new HashSet<>();
        a.add(10);
        a.add(20);
        a.add(10);
        a.add(30);
        a.add(20);
        a.add(40);
        System.out.println(a);
        System.out.println();
        System.out.println(a.contains(30));
        System.out.println();
        a.remove(20);
        System.out.println(a);
        System.out.println(a.size());
    }
}
