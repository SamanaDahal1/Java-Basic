package CoreJavaRevision.BankingSystem;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    List<BankAccount> bankAccounts = new ArrayList<>();
    void addBankAccount(BankAccount bankAccount){
        bankAccounts.add(bankAccount);
    }
    BankAccount findAccountByNumber(int accountNum){
        for(BankAccount bankAccount :bankAccounts){
            if(bankAccount.getAccountNumber()==accountNum){
                return bankAccount;
            }
        }
        return null;
    }
    double deposit(int accountNum,double amount){
        BankAccount bankAccount= findAccountByNumber(accountNum);
        if(bankAccount!=null){
            return bankAccount.deposit(amount);
        }
        return 0;
    }
    double withdraw(int accountNum,double amount){
        BankAccount bankAccount = findAccountByNumber(accountNum);
        if(bankAccount!=null){
            return bankAccount.withdraw(amount);
        }
        return 0;
    }
    void displayAllAccounts(){
        for(BankAccount bankAccount : bankAccounts){
            System.out.println("Account Number: "+bankAccount.getAccountNumber()+
                    "\nAccount Holder Name: "+bankAccount.getHolderName()+
                    "\nCurrent Balance: "+bankAccount.getBalance()+
                    "\nInterest: "+bankAccount.calculateInterest());
        }
    }

}
