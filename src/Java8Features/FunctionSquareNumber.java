package Java8Features;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class FunctionSquareNumber {
    public static void main(String[] args) {
        ArrayList<Integer> stores = new ArrayList<>();
        Function<Integer,Integer> sqaureNum = (num)->num*num;
        Scanner src = new Scanner(System.in);
        System.out.println("Enter 5 numbers: ");
        for(int i = 0 ; i<5;i++){
            int num = src.nextInt();
            int squareStore = sqaureNum.apply(num);
            stores.add(squareStore);
        }
        System.out.println("Sqaure of given number are: ");
        for(int store: stores){
            System.out.println(store);
        }


    }
}
