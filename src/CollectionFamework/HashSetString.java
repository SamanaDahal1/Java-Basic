package CollectionFamework;

import java.util.HashSet;

public class HashSetString {
    public static void main(String[] args){
        HashSet<String> a = new HashSet<>();
        a.add("Java");
        a.add("Python");
        a.add("Java");
        a.add("C++");
        a.add("Python");
        a.add("JavaScript");
        System.out.println(a);
        System.out.println(a.size());
        System.out.println(a.contains("Java"));
        a.remove("Python");
        System.out.println(a.contains("Python"));
    }
}
