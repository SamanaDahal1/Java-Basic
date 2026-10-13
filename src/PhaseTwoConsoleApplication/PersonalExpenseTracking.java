package PhaseTwoConsoleApplication;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

enum Category{
    health(0),
    transportation(0),
    technology(0),
    saving(0);

    final int storeCat;

    Category(int storeCat){

        this.storeCat=storeCat;
    }


}
class Expense{
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

class Budget {
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
public class PersonalExpenseTracking {
    static  void searchCondition(Collection<Expense> collections,Predicate<Expense> predicate){
        collections.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        Map <Long,Expense> storeExpense = new HashMap<>();
        Map<Category, Budget> storeBudget = new HashMap<>();
        LocalDate nowDate = LocalDate.now();
        while (true) {
            System.out.println();
            System.out.print("Enter a number from 1/2/3/4/5/6/7/8/9\n" +
                    "1.Add Expense\n" +
                    "2.Remove Expense\n" +
                    "3.List Expense\n" +
                    "4.Show total by Category\n" +
                    "5.Show total by month \n" +
                    "6.Show Top 3 expense and average\n" +
                    "7.Search Expenses\n" +
                    "8.Monthly budget\n" +
                    "9.Exist\n" +
                    "Enter your choice: ");
            int choice = src.nextInt();
            System.out.println();
            if (choice == 1) {
                System.out.print("Enter number of expenses: ");
                int size = src.nextInt();
                for (int i = 0; i < size; i++) {
                    System.out.print("Enter your id : ");
                    int id = src.nextInt();
                    if(storeExpense.containsKey((long)id)){
                        System.out.println("Id already exist. Try again with new id.");
                        continue;
                    }
                    src.nextLine();
                    System.out.print("Enter title of Expense: ");
                    String title = src.nextLine();
                    if(title.isEmpty()){
                        System.out.print("Cant leave empty. Must fill");
                        continue;
                    }
                    System.out.print("Enter amount: ");
                    double amount = src.nextDouble();
                    if(amount<=0){
                        System.out.println("Invalid input. Amount should be greater than 0");
                        continue;
                    }
                    System.out.print("Choose Category: 1/2/3/4\n");
                    Category[] categories = Category.values();
                    for (Category category : categories) {
                        System.out.println(category);
                    }
                    System.out.print("Enter Category: ");
                    int choose = src.nextInt();
                    if (choose < 1 || choose > 4) {
                        System.out.println("Invalid category. Choose between 1 and 4.");
                        continue;
                    }
                    Category here = categories[choose - 1];
                    src.nextLine();

                    System.out.print("Enter Date (dd/MM/yyyy): ");
                    String dateUser = src.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    try {
                        LocalDate date = LocalDate.parse(dateUser,formatter);
                        if(date.isAfter(nowDate)){
                            System.out.println("Invalid Input Future date cant be store");
                            continue;
                        }
                        Expense expense = new Expense(id, title, amount, here, date);
                        storeExpense.put((long)id,expense);
                        System.out.println("Expenses Added Successfully");
                    }catch (DateTimeParseException e){
                        System.out.println("Follow format(dd/MM/yyyy)");
                    }
                }

            } else if (choice == 2) {
                System.out.println("Enter id to remove");
                int id = src.nextInt();

                    Expense found = storeExpense.remove((long)id);
                    if(found==null){
                        System.out.println("ID Doesnt exist");
                    }
                    else {
                        System.out.println("Removed SuccessFully");
                    }


            } else if (choice == 3) {
                System.out.println("How you want to get list of expense:\n" +
                        "1.Sorted by date\n" +
                        "2.Sorted by amount\n" +
                        "3.Sorted by category");
                int sortedChoice = src.nextInt();
                if (sortedChoice == 1) {
                    storeExpense.values().stream()
                            .sorted(Comparator.comparing(Expense::getDate).reversed())
                            .forEach(System.out::println);
                } else if (sortedChoice == 2) {
                    storeExpense.values().stream()
                            .sorted(Comparator.comparing(Expense::getAmount).reversed())
                            .forEach(System.out::println);
                } else if (sortedChoice == 3) {
                    storeExpense.values().stream()
                            .sorted(Comparator.comparing(Expense::getCategory))
                            .forEach(System.out::println);
                }
                else {
                    System.out.println("Invalid input. Choose 1,2 or 3");
                }

            }
            else if (choice==4) {
                Map<Category, Double> collectCategory = storeExpense.values().stream()
                        .collect(groupingBy(Expense::getCategory,summingDouble(Expense::getAmount)));
                System.out.println(collectCategory);
            }
            else if (choice==5) {
                Map<YearMonth,Double> collectByDate = storeExpense.values().stream()
                        .collect(groupingBy(Expense -> YearMonth.from(Expense.getDate()),summingDouble(Expense::getAmount)));
                System.out.println(collectByDate);
                
            }
            else if (choice==6) {
                List<Expense> listExpensive = storeExpense.values().stream()
                        .sorted(Comparator.comparing(Expense::getAmount).reversed())
                        .limit(3)
                        .toList();
                double averageAmt = storeExpense.values().stream()
                        .mapToDouble(Expense::getAmount)
                        .average().orElse(0.0);

                System.out.println("Top three Expense: ");
                System.out.println(listExpensive);
                System.out.println(" Average Expenses: "+averageAmt);
            }
            else if (choice==7) {
                System.out.println("Enter 1/2/3 \n" +
                        "1.expenses between two dates\n" +
                        "2.expenses above an amount\n" +
                        "3.expenses whose title contains a keyword");
                int chosen= src.nextInt();
                src.nextLine();
                if(chosen==1){
                    System.out.print("Enter Date From(dd/MM/yyyy): ");
                    String fDateUser = src.nextLine();
                    DateTimeFormatter fromFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fromDate = LocalDate.parse(fDateUser,fromFormatter);
                    if(fromDate.isAfter(nowDate)){
                        System.out.println("Invalid Input");
                        continue;
                    }
                    System.out.print("Enter Date To (dd/MM/yyyy): ");
                    String toDateUser = src.nextLine();
                    DateTimeFormatter toFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate toDate = LocalDate.parse(toDateUser,toFormatter);
                    if(fromDate.isAfter(toDate) || toDate.isAfter(nowDate)){
                        System.out.println("Invalid Input");
                        continue;
                    }
                    else {
                        searchCondition(storeExpense.values(),
                                a -> !a.getDate().isBefore(fromDate) && !a.getDate().isAfter(toDate) );
                    }

                }
                else if (chosen==2) {
                    System.out.println("Enter amount: ");
                    double amount = src.nextDouble();
                    if(amount<=0){
                        System.out.println("Invalid Amount. Should be more than 0");
                    }
                    else {
                        searchCondition(storeExpense.values(),
                                a->a.getAmount()>amount);

                }
                }
                else if (chosen==3) {
                    System.out.print("Enter keyword to search: ");
                    String keyword = src.nextLine();
                    String ignoreCaseKeyword= keyword.toLowerCase();
                    searchCondition(storeExpense.values(),
                            a->a.getTitle().toLowerCase().contains(ignoreCaseKeyword));
                }

            }
            else if (choice==8) {
                System.out.println("Enter 1 or 2 for \n" +
                        "Setting Monthly budget\n" +
                        "Viewing Budget left");
                int budgetAction= src.nextInt();
                if(budgetAction==1){
                    System.out.print("Choose Category to set budget: 1/2/3/4\n");
                    Category[] categories = Category.values();
                    for (Category category : categories) {
                        System.out.println(category);
                    }
                    int setBudget = src.nextInt();
                    if(setBudget==1){
                        System.out.print("Enter Budget for Health: ");
                        int healthBudget = src.nextInt();
                        if(healthBudget<=0){
                            System.out.println("Budget should be more than 0");
                        }else {
                            storeBudget.put(Category.health, new Budget(Category.health, healthBudget));
                            System.out.println("Set Successfully");
                        }
                    }
                    else if (setBudget==2) {
                        System.out.print("Enter Budget for Transportation: ");
                        int transportBudget = src.nextInt();
                        if(transportBudget<=0){
                            System.out.println("Budget should be more than 0");
                        }else {
                            storeBudget.put(Category.transportation,new Budget(Category.transportation,transportBudget));
                            System.out.println("Set Successfully");
                        }

                    }
                    else if (setBudget==3) {
                        System.out.print("Enter Budget for Technology: ");
                        int techBudget = src.nextInt();
                        if(techBudget<=0){
                            System.out.println("Budget should be more than 0");
                        }else {
                            storeBudget.put(Category.technology,new Budget(Category.technology,techBudget));
                            System.out.println("Set Successfully");
                        }

                    }
                    else if (setBudget==4) {
                        System.out.print("Enter Budget for Saving: ");
                        int saveBudget = src.nextInt();
                        if(saveBudget <=0){
                            System.out.println("Budget should be more than 0");
                        }else {
                            storeBudget.put(Category.saving,new Budget(Category.saving,saveBudget));
                            System.out.println("Set Successfully");
                        }
                    }
                    else {
                        System.out.println("Invalid input. Only accept 1/2/3/4");
                    }
                }
                else if (budgetAction == 2) {
                    System.out.println("Budget For Month \n");
                    for (Budget budget : storeBudget.values()) {
                        double amtbudget = budget.getMonthLimit();
                        double spent = 0;

                        for (Expense expense : storeExpense.values()) {
                            if (expense.getCategory() == budget.getCategory() && YearMonth.from(expense.getDate()).equals(YearMonth.now())) {
                                spent += expense.getAmount();
                            }
                        }

                        double minus = amtbudget - spent;

                        System.out.println("Category: " + budget.getCategory());
                        System.out.println("Budget Limit: " + amtbudget);
                        System.out.println("Spend Total: " + spent);

                        if (minus >= 0) {
                            System.out.println("Amount left: " + minus);
                        } else {
                            System.out.println("Warning! Over budget by " + (-minus));
                        }
                    }
                }
                else {
                    System.out.println("Invalid input. Input should be 1 or 2");
                }
            }
            else if (choice == 9) {
                System.exit(0);
                }

            }

        }
    }
