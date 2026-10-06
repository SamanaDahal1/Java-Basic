package Java8Features;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPractice {
    public static void main(String[] args) {
        ArrayList<String> stores = new ArrayList<>();
        Consumer<String> consumer = (name)->System.out.println(name);
        Scanner src = new Scanner(System.in);
        System.out.println("Enter 5 names: ");
        for(int i=0 ; i<5;i++){
            String name = src.next();
            stores.add(name);
        }
        System.out.println("Name: ");
        for(String store : stores){
            consumer.accept(store);
        }


    }
}
