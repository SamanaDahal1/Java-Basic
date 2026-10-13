package PhaseTwoConsoleApplication;
public class Budget {
    private Category category;
    private double monthLimit;

    Budget (Category category , double monthLimit){
        this.category=category;
        this.monthLimit =monthLimit;
    }

    public Category getCategory() {
        return category;
    }

    public double getMonthLimit() {
        return monthLimit;
    }

}