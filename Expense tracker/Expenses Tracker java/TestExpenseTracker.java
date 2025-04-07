import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



public class TestExpenseTracker {
    
    @Test
    void testAddExpense() {
        List<Expense> expenses = new ArrayList<>();
        Expense expense = new Expense("2024-02-26", "Lunch", 15.50);
        expenses.add(expense);
        
        assertEquals(1, expenses.size());
        assertEquals("2024-02-26", expense.getDate());
        assertEquals("Lunch", expense.getDescription());
        assertEquals(15.50, expense.getAmount(), 0.01);
    }

    @Test
    void testCalculateTotalExpenses() {
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense("2024-02-26", "Lunch", 10.00));
        expenses.add(new Expense("2024-02-26", "Dinner", 20.00));
        
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        
        assertEquals(30.00, total, 0.01);
    }

    @Test
    void testViewExpenses() {
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense("2024-02-26", "Lunch", 10.00));
        
        String output = "Expenses:\n";
        for (Expense expense : expenses) {
            output += expense.getDate() + " " + expense.getDescription() + " " + expense.getAmount() + "\n";
        }
        
        assertTrue(output.contains("Lunch"));
        assertTrue(output.contains("10.00"));
    }
}
