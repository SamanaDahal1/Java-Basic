package CoreJavaRevision.BankingSystem;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        BankAccount bankAccount1= new SavingAccount(1,"Rames",10000);
        BankAccount bankAccount2= new CurrentAccount(2,"Rabindra",5000,2000);
        bankService.addBankAccount(bankAccount1);
        bankService.addBankAccount(bankAccount2);
        bankService.deposit(1,2000);
        bankService.withdraw(1,3000);
        bankService.withdraw(2,6000);
        bankService.displayAllAccounts();

    }
}
