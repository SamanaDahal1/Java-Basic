package CoreJavaRevision.BankingSystem;

public class SavingAccount extends BankAccount{
    SavingAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }


    @Override
    double withdraw(double amount) {
        if(amount<=getBalance()){
          setBalance(getBalance()-amount);
        }
        return getBalance();
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.04;
    }
}
