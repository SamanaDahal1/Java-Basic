package ExceptionHandling;

import java.util.Scanner;
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }


}

public class Throws {
        static void checkAge(int age) throws InvalidAgeException {
            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or above");
            } else {
                System.out.println("You can vote");
            }
        }
        public static void main(String[] args) {

            try {
                Scanner s = new Scanner(System.in);
                System.out.print("Enter your age: ");
                int age = s.nextInt();
                checkAge(age);
            }
            catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Thank You");
        }
    }



