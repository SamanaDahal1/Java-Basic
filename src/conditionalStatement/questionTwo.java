package conditionalStatement;

import java.util.Scanner;

public class questionTwo {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number to check odd or even: ");
        int num = s.nextInt();
        if(num%2==0){
            System.out.println(num + " is even number");
        }
        else{
            System.out.println(num + " is odd number");
        }
    }
}
