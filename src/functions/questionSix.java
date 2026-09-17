package functions;

import java.util.Scanner;

public class questionSix {
    public static void main (String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word= src.next();
        System.out.println(palindrome(word));

    }
    static boolean palindrome(String a){

        String reverse = new StringBuilder(a).reverse().toString();
        if (a.equals(reverse)){
            return true;
        }
        else{
            return false;
        }

    }
}
