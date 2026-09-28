package CollectionFamework;

import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {
    public static void main(String[] args){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("China", 370);
        map.put("Nepal",344);
        map.put("India",344);

        map.put("India",200);
        System.out.println(map);
        System.out.println();

        if(map.containsKey("Nepal")){
            System.out.println("Yes");
        }
        else {
            System.out.println("NO");
        }

        System.out.println();
        System.out.println(map.get("China"));
        System.out.println(map.get("Bhutan"));
        System.out.println();

        for(Map.Entry<String, Integer> e: map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }



    }
}
