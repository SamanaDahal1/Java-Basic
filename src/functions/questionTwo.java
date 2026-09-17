package functions;

import java.util.Scanner;

public class questionTwo {
    public static void main (String[] args){
        questionTwo obj = new questionTwo();
        Scanner s =new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = s.nextInt();

        System.out.println(obj.isPrime(num));
    }
    public boolean isPrime(int a){

        for (int i = 2; i < a -1; i++) {
            if(a%i==0){
                return false;
            }

        }
       return true;
    }
}
