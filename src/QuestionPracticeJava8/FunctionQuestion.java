package QuestionPracticeJava8;

import java.util.Scanner;
import java.util.function.Function;

public class FunctionQuestion {
    public static void main(String[] args) {
        Function<Integer,Integer> nums = (a)->a*2;
        Scanner src = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = src.nextInt();
        System.out.println("Result: "+ nums.apply(num));
    }
}