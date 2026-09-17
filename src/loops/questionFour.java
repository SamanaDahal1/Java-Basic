package loops;

import java.util.Scanner;

public class questionFour {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = s.nextInt();
        boolean b = true;
        for (int i = 2; i < num -1; i++) {
            if(num%i==0){
                b= false;
            }

        }
        if(b){
            System.out.println("prime");
        }
        else{
            System.out.println("no");
        }

    }
}