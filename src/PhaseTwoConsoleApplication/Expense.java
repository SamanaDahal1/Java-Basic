package PhaseTwoConsoleApplication;

import java.time.LocalDate;

public class Expense{
    private int id ;
    private  String title;
    private double amount;
    Category category;
    private LocalDate date;

    Expense(int id ,String title ,double amount,Category category,LocalDate date){
        this.amount=amount;
        this.id = id;
        this.title = title;
        this.category = category;
        this.date= date;
    }

    public double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }
    @Override
    public String toString() {
        return "ID: " + id +
                ", Title: " + title +
                ", Amount: " + amount +
                ", Category: " + category +
                ", Date: " + date;
    }
}