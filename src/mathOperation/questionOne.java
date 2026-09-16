package mathOperation;

import java.util.Scanner;

public class questionOne {
    public static void main(String[] args){
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter your 1st number: ");
        float num1 = scr.nextFloat();
        System.out.print("Enter your 2nd number: ");
        float num2 = scr.nextFloat();
        float sum = num1+num2;
        float diff = num1-num2;
        float prod= num1*num2;
        float quo = num1/num2;
        float rem = num1%num2;
        System.out.printf("Sum of these two number is %f ,Diiference of these two number is %f product of these two number is %f quotient of these two number is %f remainder of these two number is %f ", sum, diff, prod,quo,rem);


    }
}
