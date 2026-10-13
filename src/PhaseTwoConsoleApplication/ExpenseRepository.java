package PhaseTwoConsoleApplication;

import java.util.*;

public class ExpenseRepository implements GenericRepository<Expense,Long>{

    private final Map<Long , Expense> storeExpense = new HashMap<>();
    @Override
    public void save(Expense expense) {
        storeExpense.put((long) expense.getId(), expense);
    }
    @Override
    public Optional<Expense> find(Long id) {
        return Optional.ofNullable(storeExpense.get(id));
    }
    @Override
    public List<Expense> findAll() {
        return new ArrayList<>(storeExpense.values());
    }
    @Override
    public boolean deleteBy(Long id) {
        return storeExpense.remove(id) != null;
    }
}
