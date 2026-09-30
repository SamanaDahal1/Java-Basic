package ExceptionHandling;

import java.util.Scanner;

class InvalidAgeException1 extends Exception{
    public InvalidAgeException1(String message){
        super(message);
    }
}

public class ThrowCustomException {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = s.nextInt();
        try {

            if (age < 18) {
                throw new InvalidAgeException1("Must be 18 or above" );
            } else {
                System.out.println("You can vote");
            }
        }
        catch (InvalidAgeException1 e){
            System.out.println( e.getMessage());
        }
        System.out.println("Thank you");
    }
}
