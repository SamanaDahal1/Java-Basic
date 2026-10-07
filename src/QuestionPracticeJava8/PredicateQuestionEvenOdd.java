package QuestionPracticeJava8;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateQuestionEvenOdd {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        Predicate<Integer> evenOrNot = num->{
            if(num%2==0) {
                return true;
            }
            else {
                return false;
            }
        };
        System.out.println("Enter a num: ");
        int num = src.nextInt();
        if(evenOrNot.test(num)){
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }

    }
}
