package stringsMethods;

import java.util.Scanner;

public class questionOne {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter any word: ");
        String word = s.next();
        System.out.println(word.length());
        System.out.println(word.toUpperCase());
        System.out.println(word.toLowerCase());
    }
}
