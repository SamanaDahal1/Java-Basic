package loops;

import java.util.Scanner;

public class questionFive {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number upto where you want: ");
        int n = s.nextInt();

        int a=0;
        int b=1;
        int c;

        for (int i=0;i<=n;i++){
            System.out.println(a);
            c= a+b;
            a=b;
            b=c;

        }

    }
}
