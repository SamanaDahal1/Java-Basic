package ExceptionHandling;

import java.util.Scanner;

class InsufficientbalanceException extends Exception{
    public InsufficientbalanceException(String message){
        super(message);
    }
}

public class MixedExceptionBankWithdrawal {
    static void withdraw(int balance, int amount) throws InsufficientbalanceException{
        if(amount>balance){
            throw new InsufficientbalanceException("Insufficient Balance");
        }
        else {
            int amt = balance-amount;
            System.out.println("Remaining Balance: " + amt);
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter balance: ");
        int balance = s.nextInt();
        System.out.print("Enter amount: ");
        int amount = s.nextInt();
        try {
            withdraw(balance,amount);
        }
        catch (InsufficientbalanceException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Thank You");

    }
}
