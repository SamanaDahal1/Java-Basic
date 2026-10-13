package PhaseTwoConsoleApplication;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.time.YearMonth;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public void addExpense(Expense expense) {
        repository.save(expense);
    }

    public Expense findExpense(Long id) {
        return repository.find(id).orElse(null);
    }

    public boolean removeExpense(Long id) {
        return repository.deleteBy(id);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public List<Expense> sortByDate() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getDate).reversed())
                .toList();
    }

    public List<Expense> sortByAmount() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getAmount).reversed())
                .toList();
    }

    public List<Expense> sortByCategory() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getCategory))
                .toList();
    }

    public Map<Category, Double> totalByCategory() {
        return repository.findAll().stream()
                .collect(groupingBy(Expense::getCategory,
                        summingDouble(Expense::getAmount)));
    }

    public Map<YearMonth, Double> totalByMonth() {
        return repository.findAll().stream()
                .collect(groupingBy(
                        expense -> YearMonth.from(expense.getDate()),
                        summingDouble(Expense::getAmount)));
    }

    public List<Expense> getTopThreeExpenses() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Expense::getAmount).reversed())
                .limit(3)
                .toList();
    }

    public double getAverageExpense() {
        return repository.findAll().stream()
                .mapToDouble(Expense::getAmount)
                .average()
                .orElse(0.0);
    }

    public List<Expense> searchExpenses(Predicate<Expense> predicate) {
        return repository.findAll().stream()
                .filter(predicate)
                .toList();
    }
}
