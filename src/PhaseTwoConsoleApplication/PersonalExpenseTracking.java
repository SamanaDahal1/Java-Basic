package PhaseTwoConsoleApplication;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class PersonalExpenseTracking {

    static void searchCondition(Collection<Expense> collections, Predicate<Expense> predicate) {
        collections.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        ExpenseRepository repository = new ExpenseRepository();
        ExpenseService expenseService = new ExpenseService(repository);
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
                    "9.Exit\n" +
                    "Enter your choice: ");
            int choice = src.nextInt();
            System.out.println();

            if (choice == 1) {
                System.out.print("Enter number of expenses: ");
                int size = src.nextInt();
                for (int i = 0; i < size; i++) {
                    System.out.print("Enter your id : ");
                    int id = src.nextInt();
                    if (expenseService.findExpense((long) id) != null) {
                        System.out.println("Id already exist. Try again with new id.");
                        continue;
                    }
                    src.nextLine();
                    System.out.print("Enter title of Expense: ");
                    String title = src.nextLine();
                    if (title.isEmpty()) {
                        System.out.print("Cant leave empty. Must fill");
                        continue;
                    }
                    System.out.print("Enter amount: ");
                    double amount = src.nextDouble();
                    if (amount <= 0) {
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
                        LocalDate date = LocalDate.parse(dateUser, formatter);
                        if (date.isAfter(nowDate)) {
                            System.out.println("Invalid Input Future date cant be store");
                            continue;
                        }
                        Expense expense = new Expense(id, title, amount, here, date);
                        expenseService.addExpense(expense);
                        System.out.println("Expenses Added Successfully");
                    } catch (DateTimeParseException e) {
                        System.out.println("Follow format(dd/MM/yyyy)");
                    }
                }
            }
            else if (choice == 2) {
                System.out.println("Enter id to remove");
                int id = src.nextInt();
                boolean found = expenseService.removeExpense((long) id);
                if (!found) {
                    System.out.println("ID Doesnt exist");
                } else {
                    System.out.println("Removed SuccessFully");
                }
            }
            else if (choice == 3) {
                System.out.println("How you want to get list of expense:\n" +
                        "1.Sorted by date\n" +
                        "2.Sorted by amount\n" +
                        "3.Sorted by category");
                int sortedChoice = src.nextInt();
                if (sortedChoice == 1) {
                    expenseService.sortByDate()
                            .forEach(System.out::println);
                }
                else if (sortedChoice == 2) {
                    expenseService.sortByAmount()
                            .forEach(System.out::println);
                }
                else if (sortedChoice == 3) {
                    expenseService.sortByCategory()
                            .forEach(System.out::println);
                }
                else {
                    System.out.println("Invalid input. Choose 1,2 or 3");
                }
            }
            else if (choice == 4) {
                Map<Category, Double> collectCategory = expenseService.totalByCategory();
                System.out.println(collectCategory);
            }
            else if (choice == 5) {
                Map<YearMonth, Double> collectByDate = expenseService.totalByMonth();

                System.out.println(collectByDate);

            }
            else if (choice == 6) {
                List<Expense> listExpensive = expenseService.getTopThreeExpenses();
                double averageAmt = expenseService.getAverageExpense();
                System.out.println("Top three Expense: ");
                System.out.println(listExpensive);
                System.out.println(" Average Expenses: " + averageAmt);
            }
            else if (choice == 7) {
                System.out.println("Enter 1/2/3 \n" +
                        "1.expenses between two dates\n" +
                        "2.expenses above an amount\n" +
                        "3.expenses whose title contains a keyword");
                int chosen = src.nextInt();
                src.nextLine();
                if (chosen == 1) {
                    System.out.print("Enter Date From(dd/MM/yyyy): ");
                    String fDateUser = src.nextLine();
                    DateTimeFormatter fromFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    try {
                        LocalDate fromDate = LocalDate.parse(fDateUser, fromFormatter);
                        if (fromDate.isAfter(nowDate)) {
                            System.out.println("Invalid Input");
                            continue;
                        }
                        System.out.print("Enter Date To (dd/MM/yyyy): ");
                        String toDateUser = src.nextLine();
                        DateTimeFormatter toFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate toDate = LocalDate.parse(toDateUser, toFormatter);
                        if (fromDate.isAfter(toDate) || toDate.isAfter(nowDate)) {
                            System.out.println("Invalid Input");
                            continue;
                        }
                        else {
                            expenseService.searchExpenses(
                                    a -> !a.getDate().isBefore(fromDate)
                                            && !a.getDate().isAfter(toDate)
                            ).forEach(System.out::println);
                        }

                    }
                    catch (DateTimeParseException e) {
                        System.out.println("Follow format(dd/MM/yyyy)");
                    }

                }
                else if (chosen == 2) {
                    System.out.println("Enter amount: ");
                    double amount = src.nextDouble();
                    if (amount <= 0) {
                        System.out.println("Invalid Amount. Should be more than 0");
                    } else {
                        searchCondition(expenseService.getAllExpenses(),
                                a -> a.getAmount() > amount);
                    }
                }
                else if (chosen == 3) {
                    System.out.print("Enter keyword to search: ");
                    String keyword = src.nextLine();
                    String ignoreCaseKeyword = keyword.toLowerCase();
                    searchCondition(expenseService.getAllExpenses(),
                            a -> a.getTitle().toLowerCase().contains(ignoreCaseKeyword));
                }
                else {
                    System.out.println("Invalid input. Choose 1, 2 or 3");
                }
            }
            else if (choice == 8) {
                System.out.println("Enter 1 or 2 for \n" +
                        "Setting Monthly budget\n" +
                        "Viewing Budget left");
                int budgetAction = src.nextInt();
                if (budgetAction == 1) {
                    System.out.print("Choose Category to set budget: 1/2/3/4\n");
                    Category[] categories = Category.values();
                    for (Category category : categories) {
                        System.out.println(category);
                    }
                    int setBudget = src.nextInt();
                    if (setBudget >= 1 && setBudget <= categories.length) {
                        Category category = categories[setBudget - 1];
                        System.out.print("Enter Budget for " + category + ": ");
                        double limit = src.nextDouble();
                        if (limit <= 0) {
                            System.out.println("Budget should be more than 0");
                        } else {
                            storeBudget.put(category, new Budget(category, limit));
                            System.out.println("Set Successfully");
                        }
                    } else {
                        System.out.println("Invalid input. Only accept 1/2/3/4");
                    }
                }
                else if (budgetAction == 2) {
                    System.out.println("Budget For Month \n");
                    for (Budget budget : storeBudget.values()) {
                        double amtbudget = budget.getMonthLimit();
                        double spent = 0;
                        for (Expense expense : expenseService.getAllExpenses()) {
                            if (expense.getCategory() == budget.getCategory()
                                    && YearMonth.from(expense.getDate())
                                    .equals(YearMonth.now())) {
                                spent += expense.getAmount();
                            }
                        }
                        double minus = amtbudget - spent;
                        System.out.println("Category: " + budget.getCategory());
                        System.out.println("Budget Limit: " + amtbudget);
                        System.out.println("Spend Total: " + spent);
                        if (minus >= 0) {
                            System.out.println("Amount left: " + minus);
                        }
                        else {
                            System.out.println("Warning! Over budget by " + (-minus));
                        }
                    }

                }
                else {
                    System.out.println("Invalid input. Input should be 1 or 2");
                }

            }
            else if (choice == 9) {
                System.out.println("Exiting Personal Expense Tracker.");
                break;
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }
}