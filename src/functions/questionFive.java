package functions;

import java.util.Scanner;

public class questionFive {
    public static void main(String[] args){
        System.out.println(fac(5));

    }
    static int fac(int a){
        if(a>1){
            return a*fac(a-1);
        }
        else{
            return 1;
        }

    }
}
