package loops;

import java.util.Scanner;

public class questionThree {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter A number: ");
        int num = s.nextInt();
        int b=1;
        for (int i=1 ; i<=num; i++){
            b*=i;
        }
        System.out.println(b);
    }
}
