package oop;
/*
Q9: Encapsulation — Setter

Create a BankAccount2 class with:

- accountHolder
- balance

Requirements:

1. Make both variables private.
2. Create a parameterized constructor.
3. Create getBalance() → return the balance.
4. Create setBalance(int balance) → change the balance.
5. Create displayAccount() → display account holder and balance.

In main():

- Create one BankAccount2 object.
- Display the account.
- Change the balance using setBalance().
- Display the account again.

🆕 New concept:
Setter — a public method used to change a private variable.
*/

class BankAccount2{
   private String accountHolder;
   private int balance;

   BankAccount2 (String accountHolder,int balance){
       this.accountHolder=accountHolder;
       this.balance=balance;
   }
   public int getBalance(){
       return balance;
   }
   public void setBalance(int balance){
      this.balance=balance;
   }
   public void displayAccount(){
       System.out.printf("Account Holder :%s\nBalance: %d\n",accountHolder,balance);
   }
}

public class QuestionNine {
    public static void main(String[] args){
        BankAccount2 person1= new BankAccount2("Eve",800);
//        BankAccount2 person2 = new BankAccount2("Ave",1000);
        person1.displayAccount();
        System.out.println(person1.getBalance());
        person1.setBalance(4500);
        System.out.println();
        person1.displayAccount();
        System.out.println(person1.getBalance());

    }
}
