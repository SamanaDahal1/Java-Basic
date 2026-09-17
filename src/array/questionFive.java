package array;

import java.util.Scanner;

public class questionFive {
    public static void main (String[] arg){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter any one number: ");
        int num =s.nextInt();
        int[] a = {2,3,4,5,6};
        boolean b= false;

        for(int element : a){
            if (element==num){
                b=true;
            }

        }
        if(b){
            System.out.println(num + " Exist");
        }
        else{
            System.out.println(num + " doesn't Exist");
        }

    }
}
