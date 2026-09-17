package stringsMethods;

import java.util.Scanner;

public class questionFive {
    public static void main(String[] args){
        System.out.println(five());
    }
    public static int five(){
        Scanner src = new Scanner(System.in);
        System.out.print("enter a word: ");
        String a = src.nextLine();
        int count =0;
        String b= a.toLowerCase();
        for(int i=0;i<a.length();i++) {
            if(b.charAt(i)=='a'||b.charAt(i)=='e' ||b.charAt(i)=='i' ||b.charAt(i)=='o' ||b.charAt(i)=='u'){
                count++;
            }
            }
        return count;
    }
}