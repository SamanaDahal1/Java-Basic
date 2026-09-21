package oop;

/*### Question 2: Bank Account

Create a `BankAccount` class with:

* Fields: `accountHolder`, `accountNumber`, `balance`, `accountType`
* Parameterized constructor
* `displayAccount()` method
* `deposit()` method to add money
* `withdraw()` method to withdraw money if sufficient balance; otherwise show `"Insufficient balance"`

In `main()`:

* Create 2 bank account objects.
* Display their details.
* Test deposit and withdrawal on one account.
* Test insufficient balance.

**Concepts:** Class, Object, Constructor, `this`, Methods, Instance Variables, `if-else`.

 */
class BankAccount{
    String accountHolder;
    int accountNumber;
    int balance;
    String accountType;

    BankAccount(String accountHolder, int accountNumber,int balance,String accountType){
        this.accountHolder=accountHolder;
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.accountType=accountType;
    }
    public void displayAccount(){
        System.out.printf(" Account Holder: %s \n Account Number: %d \n Account Type: %s \n Balance: %d \n" , accountHolder,accountNumber,accountType,balance);

    }



    public int deposit() {
        int addNum= 7000;
        balance+=addNum ;
        return balance;
    }
    public int withdraw(){
        int minuNum= 8000;
        if(minuNum<=balance){
            balance-=minuNum;
            return balance;
        }
        else{
            System.out.println(" Insufficient balance ");
            return balance-minuNum;
        }
    }
}

public class questionTwo {
    public static void main(String[] args){
        BankAccount man1 = new BankAccount("Pratima",234556775, 100000, "Saving");
        BankAccount man2 = new BankAccount("Alisha",233456775, 500, "Saving");


        man1.displayAccount();
        man2.displayAccount();
        System.out.println(" After depositing your total bank balance: "+ man2.deposit());
        System.out.println(" After withdrawing your total bank balance: "+man2.withdraw());
        ;


    }
}
