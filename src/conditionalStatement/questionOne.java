package conditionalStatement;

import java.util.Scanner;

public class questionOne {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        float num = s.nextFloat();

        if(num<0){
            System.out.println(num + " This is negative number");
        }
        else if (num==0) {
            System.out.println(num + " This is zero");
        }
        else{
            System.out.println(num + " This is positive number");
        }
    }
}
