package conditionalStatement;

import java.util.Scanner;

public class questionThree {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your 1st number: ");
        int num1 = s.nextInt();
        System.out.println("Enter your 2nd number: ");
        int num2 = s.nextInt();
        System.out.println("Enter your 3rd number: ");
        int num3 = s.nextInt();
        if(num1>num3 && num1>num2){
            System.out.println( num1 +" is largest");
        }
        else if (num2>num3 && num1<num2){
            System.out.println(num2 +" is largest");
        }
        else {
            System.out.println(num3+" is largest");
        }
    }

}
