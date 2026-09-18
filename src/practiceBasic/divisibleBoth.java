package practiceBasic;
//Check whether a number is divisible by both 3 and 5
import java.util.Scanner;

public class divisibleBoth {
    public static void main(String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = src.nextInt();
        if(num%3==0 && num%5==0){
            System.out.println("Yess this number is divisible by both 3 and 5");
        }
        else{
            System.out.println("This number isnt divisible by both 3 and 5");
        }
    }
}
