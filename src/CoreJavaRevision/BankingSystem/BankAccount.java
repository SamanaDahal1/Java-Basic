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

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    double deposit(double amount) throws InvalidAmountException{
        if(amount>0){
        return balance+=amount;
        }
        throw new InvalidAmountException("Deposit Amount should be greater than 0");
    }
    abstract double withdraw(double amount) throws InsufficientBalanceException,InvalidAmountException;
    abstract double calculateInterest();
}
