package stringsMethods;

import java.util.Scanner;

public class questionFour {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String a = src.nextLine();
        String[] store =seperate(a);
        for(int i =0; i<store.length;i++) {
            if(i==0){
            System.out.println(store[i]);
            } else if (i==store.length-1) {
                System.out.println(store[i]);
            }


        }
    }
    static String[] seperate(String name) {

        String[] c = name.split(" ");
//        String fullName=c[0];
//        String lastName=c[1];
        int d = c.length -1 ;
//        System.out.println(c[0]);
//        System.out.println(c[d]);
        return c;

    }


}
