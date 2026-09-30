package ExceptionHandling;

import java.util.Scanner;

public class FinallyKeyword {
    public static void main (String[] args){
        Scanner s= new Scanner(System.in);
        System.out.print("Enter you 1st number: ");
        int num1 = s.nextInt();
        System.out.print("Enter you 2nd number: ");
        int num2 = s.nextInt();
        try {
            int a = num1/num2;
            System.out.println(a);
        }
        catch (ArithmeticException e){
            System.out.println("Cant divide by 0");
        }
        finally {
            System.out.println("Calculation finish");
        }
        System.out.println("Program Ended");

    }
}
