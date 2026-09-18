package practiceBasic;



/*
Take age as input.
Print whether the person is eligible to vote.
*/
import java.util.Scanner;

public class voteEligible {
    public static void main (String[] args){
        Scanner src = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = src.nextInt();
        if(age>=18 && age<=30){
            System.out.println("You are Eligible to work");
        }
        else if (age<=0) {
            System.out.println("Invalid age input");

        }
        else{
            System.out.println("You aren't Eligible to work");
        }
    }
}
