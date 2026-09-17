package functions;

import java.util.Scanner;

public class questionThree {
    public static void main (String[] args){
        questionThree obj = new questionThree();
        System.out.println(obj.max());

    }
    public int max(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter num in size: ");
        int size=s.nextInt();
        System.out.println("Enter num: ");
        int [] num = new int[size];
        for(int i = 0 ; i<size; i++){
            num[i]=s.nextInt();
        }
        System.out.println("Here");
        int a= num[0];
        for(int i =0; i <size; i++){
            if(num[i]>=a){
               a=num[i];
            }
        }
        return a;
    }
}
