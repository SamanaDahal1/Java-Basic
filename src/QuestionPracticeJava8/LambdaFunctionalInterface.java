package QuestionPracticeJava8;

import java.util.Scanner;

interface Calculator{
    int calculate(int a ,int b);
}
public class LambdaFunctionalInterface {
    public static void main(String[] args) {
        Calculator calculator =(a,b)->a+b;
        Scanner src = new Scanner(System.in);
        System.out.println("Enter you 1st number: ");
        int a = src.nextInt();
        System.out.println("Enter you 2nd number: ");
        int b = src.nextInt();
        System.out.println("Sum: " +calculator.calculate(a,b));

    }
}
