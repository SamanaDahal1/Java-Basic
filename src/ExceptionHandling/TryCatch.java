package ExceptionHandling;

import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter your 1st number: ");
        int num1 = src.nextInt();
        System.out.print("Enter your second number: ");
        int num2 = src.nextInt();
        try {
           int a = num1/num2;
           System.out.println("Result: "+a);
        } catch (Exception e) {
            System.out.println("Cannot divide by zero");
        }
        System.out.println("Program ended");
    }
}
