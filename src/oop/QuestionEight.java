package oop;
/*
Q8: Encapsulation

Create a BankAccount1 class with:

- accountHolder
- balance

Requirements:

1. Make both variables private.
2. Create a parameterized constructor.
3. Create getBalance() → return the balance.
4. Create deposit(int amount) → add amount to balance.
5. Create displayAccount() → display account holder and balance.

In main():

- Create one BankAccount1 object.
- Display the account.
- Deposit some money.
- Display the account again.

🆕 New concept:
Encapsulation — controlling direct access to an object's data using private.
*/

class BankAccount1{
    private String accountHolder;
     private int balance;

    BankAccount1(String accountHolder,int balance){
        this.accountHolder=accountHolder;
        this.balance=balance;
    }

    public int getBalance(){
        return balance;
    }

    public int deposit(int amount){
        balance+=amount;
        System.out.printf("Deposited Amount :%d \n",amount);
        return balance;
    }
    public void displayAccount(){
        System.out.printf("Account Holder :%s\nBalance: %d\n", accountHolder,balance);
    }
}
public class QuestionEight {
    public static void main(String[] args){
        BankAccount1 person = new BankAccount1("Sushil",20000);
        person.displayAccount();
        person.deposit(20);
        System.out.println();
        person.displayAccount();


    }
}
