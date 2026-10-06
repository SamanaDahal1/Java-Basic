package Java8Features;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class FunctionPracticeMultiplyEveryNumBy2 {
    public static void main(String[] args) {
        ArrayList<Integer> stores = new ArrayList<>();
        Function<Integer,Integer> function = (num)->num*2;
        Scanner src = new Scanner(System.in);
        System.out.println("Enter 5 numbers: ");
        for(int i =0 ; i<5 ; i++){
            int num = src.nextInt();
            int after= function.apply(num);
            stores.add(after);
        }
        System.out.println("After multiplying by 2: ");
        for(int store : stores){
            System.out.println(store);
        }

    }
}
