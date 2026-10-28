package CoreJavaRevision.BankingSystem;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    List<BankAccount> bankAccounts = new ArrayList<>();
    void addBankAccount(BankAccount bankAccount) throws DuplicateAccountException{
        for(BankAccount bankAcc:bankAccounts){
            if(bankAcc.getAccountNumber()==bankAccount.getAccountNumber()){
                throw new DuplicateAccountException("Account number already exist");
            }
        }
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
            return bankAccount.deposit(amount);
    }
    double withdraw(int accountNum,double amount) throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        BankAccount bankAccount = findAccountByNumber(accountNum);
            return bankAccount.withdraw(amount);
    }
    void transferMoney(int fromAccountNumber, int toAccountNumber,double amount) throws AccountNotFoundException, InsufficientBalanceException, InvalidAmountException,InvalidTransferException {
        BankAccount sender = findAccountByNumber(fromAccountNumber);
        BankAccount receiver =findAccountByNumber(toAccountNumber);
        if(sender==receiver){
            throw new InvalidTransferException("Cant transfer money in same account");
        }
        sender.withdraw(amount);
        receiver.deposit(amount);

    }
    void displayAllAccounts() {
        for(BankAccount bankAccount : bankAccounts){
            System.out.println("Account Number: "+bankAccount.getAccountNumber()+
                    "\nAccount Holder Name: "+bankAccount.getHolderName()+
                    "\nCurrent Balance: "+bankAccount.getBalance()+
                    "\nInterest: "+bankAccount.calculateInterest()+"\n");
        }
    }

}
