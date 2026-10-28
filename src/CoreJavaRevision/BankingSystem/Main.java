package CoreJavaRevision.BankingSystem;

public class Main {
    public static void main(String[] args){
        BankService bankService = new BankService();
        BankAccount bankAccount1= new SavingAccount(1,"Rames",10000);
        BankAccount bankAccount2= new CurrentAccount(2,"Rabindra",5000,2000);

        try {
            bankService.addBankAccount(bankAccount1);
            bankService.addBankAccount(bankAccount2);
            bankService.deposit(1,2000);
            bankService.withdraw(1,150);
            bankService.withdraw(2,200);
            bankService.transferMoney(1,2,3000);
            System.out.println("Transfer Successfully");

        }
        catch (AccountNotFoundException | InsufficientBalanceException | InvalidAmountException |
               DuplicateAccountException |InvalidTransferException e){
            System.out.println(e.getMessage());
        }

        bankService.displayAllAccounts();

    }
}
