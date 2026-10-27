package CoreJavaRevision.BankingSystem;

abstract class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    BankAccount(int accountNumber,String holderName,double balance){
        this.accountNumber=accountNumber;
        this.holderName=holderName;
        this.balance=balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    double deposit(double amount){
        return balance+=amount;
    }
    abstract double withdraw(double amount);
    abstract double calculateInterest();
}
