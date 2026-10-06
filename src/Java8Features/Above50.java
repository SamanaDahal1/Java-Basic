package Java8Features;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Above50 {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        Predicate<Integer> aboveFifty = (num1)->num1>50;
        Scanner src = new Scanner(System.in);
        System.out.println("Enter 5 numbers: ");
        for(int i=0; i<5;i++){
            int num1 = src.nextInt();

        if(aboveFifty.test(num1)){
            num.add(num1);
            }
        }
        System.out.println("Number above 50 are: ");
        for(int a : num){
            System.out.println(a);
        }
    }
}
