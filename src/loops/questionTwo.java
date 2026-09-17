package loops;

import java.util.Scanner;

public class questionTwo {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number for multiplication Table: ");
        int num = s.nextInt();
        int b =0;
        for (int i =1 ;i<=10;i++){
            b=num*i;
            System.out.println(num +"*"+ i +"="+b);
        }
    }
}
