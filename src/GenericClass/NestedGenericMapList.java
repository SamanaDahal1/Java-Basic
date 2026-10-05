package GenericClass;

import java.util.*;

public class NestedGenericMapList {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        Map<String,List<Integer>> here = new HashMap<>();
        System.out.print("Enter number of Student: ");
        int size= src.nextInt();
        for(int i =0;i<size;i++) {
            System.out.print("Enter name of a Student : ");
            String name= src.next();
            List<Integer> value = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter Marks: ");
                int addNum = src.nextInt();
                value.add(addNum);
            }
            here.put(name,value);
        }
        System.out.println(here);

        }

    }

