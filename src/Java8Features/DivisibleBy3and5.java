package Java8Features;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class DivisibleBy3and5 {
    public static void main(String[] args) {
        ArrayList<Integer>stores = new ArrayList<>();
        Predicate<Integer> predicate = (num)->num%3==0 && num%5==0;
        Scanner src = new Scanner(System.in);
        System.out.println("Enter 5 numbers: ");
        for(int i = 0; i<5;i++){
            int num = src.nextInt();
            if(predicate.test(num)){
                stores.add(num);
            }
        }
        System.out.println("Numbers Divisible by 3 and 5: ");
        for(int store:stores){
            System.out.println(store);
        }
    }
}
