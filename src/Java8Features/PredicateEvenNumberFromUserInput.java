package Java8Features;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateEvenNumberFromUserInput {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        Predicate<Integer> p = (evenNum) ->evenNum%2==0;
        ArrayList<Integer> b = new ArrayList<>();
        System.out.println("Enter 5 numbers: ");
        for(int i =0;i<5;i++){
        int num1 = src.nextInt();

        if( p.test(num1)){
            b.add(num1);
        }
        }
        System.out.println("Even numbers: ");
        for(int e : b){
        System.out.println(e);
        }
    }
}
