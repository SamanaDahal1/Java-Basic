package CoreJavaRevision.BankingSystem;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    List<BankAccount> bankAccounts = new ArrayList<>();
    void addBankAccount(BankAccount bankAccount){
        bankAccounts.add(bankAccount);
    }
    BankAccount findAccountByNumber (int accountNum) throws AccountNotFoundException{
            for(BankAccount bankAccount :bankAccounts){
                if(bankAccount.getAccountNumber()==accountNum){
                    return bankAccount;
                }
            }
            throw new AccountNotFoundException("Account Not Found");
        }

    double deposit(int accountNum,double amount) throws AccountNotFoundException, InvalidAmountException {
        BankAccount bankAccount= findAccountByNumber(accountNum);
        if(bankAccount!=null){
            return bankAccount.deposit(amount);
        }
        return 0;
    }
    double withdraw(int accountNum,double amount) throws AccountNotFoundException, InsufficientBalanceException, InvalidAmountException {
        BankAccount bankAccount = findAccountByNumber(accountNum);
        if(bankAccount!=null){
            return bankAccount.withdraw(amount);
        }
        throw new InsufficientBalanceException("Account doesnt have sufficient balance");
    }
    void displayAllAccounts() {
        for(BankAccount bankAccount : bankAccounts){
            System.out.println("Account Number: "+bankAccount.getAccountNumber()+
                    "\nAccount Holder Name: "+bankAccount.getHolderName()+
                    "\nCurrent Balance: "+bankAccount.getBalance()+
                    "\nInterest: "+bankAccount.calculateInterest());
        }
    }

}
