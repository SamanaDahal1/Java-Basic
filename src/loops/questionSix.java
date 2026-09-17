package loops;

import java.util.Locale;
import java.util.Scanner;

public class questionSix {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("enter a word: ");
        String word =  s.nextLine();
        int count =0;
        String b= word.toLowerCase();
        for(int i=0;i<word.length();i++) {
            int a = b.charAt(0);
            if(b.charAt(i)=='a'||b.charAt(i)=='e' ||b.charAt(i)=='i' ||b.charAt(i)=='o' ||b.charAt(i)=='u'){
                count++;

            };
        }
        System.out.println(count);

        }
    }

