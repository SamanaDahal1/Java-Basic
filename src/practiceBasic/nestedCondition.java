package practiceBasic;

import java.util.Scanner;

public class nestedCondition {
    public static void main (String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter your 1st number: ");
        int num1= src.nextInt();
        System.out.print("Enter your 2nd number: ");
        int num2= src.nextInt();
        System.out.println("+ for adding \n- for subtracting \n* for Multiplying, \n/ for dividing, \nand % for remainder.");
        System.out.print("Enter your operator sign: ");
        String ope= src.next();
        if(ope.equals("+")){
            System.out.println(num1+num2);
        }
        else if (ope.equals("-")){
            if(num1<num2){
                int negative =num2 -num1;
                System.out.println(negative);
            }
            else {
                System.out.println(num1-num2);
            }
        }
        else if (ope.equals("*")){
            System.out.println(num1*num2);
        }
        else if (ope.equals("%")) {
            System.out.println(num1 % num2);
        }
        else if (ope.equals("/")) {
            System.out.println(num1 / num2);
        }
        else {
            System.out.println("Invalid Operator");
        }

    }

}
