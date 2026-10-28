package CoreJavaRevision.BankingSystem;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    CurrentAccount(int accountNumber, String holderName, double balance,double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit=overdraftLimit;
    }

    @Override
    double withdraw(double amount) {
        double balance =getBalance()+overdraftLimit;
        if(balance>=amount){
            setBalance(getBalance()-amount);
        }
       return getBalance();
    }

    @Override
    double calculateInterest() {
        return 0;
    }
}
