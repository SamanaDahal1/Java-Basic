package CoreJavaRevision.BankingSystem;

public class SavingAccount extends BankAccount{
    SavingAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    double deposit(double amount) {
        return 0;
    }

    @Override
    double withdraw(double amount) {
        return 0;
    }

    @Override
    double calculateInterest() {
        return 0;
    }

}
