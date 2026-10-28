package CoreJavaRevision.BankingSystem;

public class SavingAccount extends BankAccount{
    SavingAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }


    @Override
    double withdraw(double amount) throws InsufficientBalanceException {
        if(amount<=getBalance()){
          setBalance(getBalance()-amount);
        }
        else {
            throw new InsufficientBalanceException("You have Insufficient balance");
        }
        return getBalance();
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.04;
    }
}
