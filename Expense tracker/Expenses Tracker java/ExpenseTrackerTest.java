import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;
import java.util.List;

public class ExpenseTrackerTest {

    private ExpenseTracker expenseTracker;

    @Test
    void testAddExpense() {
        Expense expense = new Expense("2024-02-26", "Lunch", 15.50);
        expenseTracker.addExpense(expense);

        List<Expense> expenses = expenseTracker.getExpenses();

        assertEquals(1, expenses.size());
        assertEquals("2024-02-26", expenseTracker.get(0).getDate());
        assertEquals("Lunch", expenses.get(0).getDescription());
        assertEquals(15.50, expenses.get(0).getAmount(), 0.01);
    }

    @Test
    void testCalculateTotalExpenses() {
        expenseTracker.addExpense(new Expense("2024-02-26", "Lunch", 10.00));
        expenseTracker.addExpense(new Expense("2024-02-26", "Dinner", 20.00));

        double total = expenseTracker.calculateTotalExpenses();

        assertEquals(30.00, total, 0.01);
    }

    @Test
    void testViewExpenses() {
        expenseTracker.addExpense(new Expense("2024-02-26", "Lunch", 10.00));

        String output = expenseTracker.viewExpenses();

        assertTrue(output.contains("Lunch"));
        assertTrue(output.contains("10.00"));
    }
}
