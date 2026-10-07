package BankManagementSystem;


import java.util.Scanner;

class Account {
    int accountNumber;
    String holderName;
    private int balance;


    int deposit(int amount) {
        return balance += amount;

    }

    int withdraw(int amount) {
        return balance -= amount;
    }

    void displayAccount() {
        System.out.printf("Account Holder BasicQuestion.Name: %s\nAccount Number: %d\nBalance: %d", holderName, accountNumber, balance);

    }

    int getBalance() {
        System.out.println("Total Balance: " + balance);
        return balance;
    }

}

    class App {
    int amount;
    Account account = new Account();
        void info() {
            Scanner src = new Scanner(System.in);
            System.out.println("Welcome to Bank\n1. Deposit\n" +
                    "2. Withdraw\n" +
                    "3. Check Balance\n" +
                    "4. Account Details\n" +
                    "5. Exit\n");
            int choice = src.nextInt();
            while (true) {
                switch (choice) {
                    case 1:
                        account.deposit(amount);
                        break;
                    case 2:
                       account.withdraw(amount);
                        break;
                    case 3:
                        account.getBalance();
                        break;
                    case 4:
                       account.displayAccount();
                        break;
                    case 5:
                        System.exit(0);


                }

            }
        }
    }

public class BankSystem {
    public static void main(String[] args){
        Account account = new Account();
        App app = new App();


    }
}
