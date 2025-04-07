import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class ExpenseTracker {
    
    private static final Scanner input = new Scanner(System.in);
    private static final List<Expense> expenses = new ArrayList<>();
    
    public static void main(String[] args) {
        while (true) {
            displayMenu();
            System.out.print("Choose an option (1-4): ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    addExpense();
                    break;
                case "2":
                    viewExpenses();
                    break;
                case "3":
                    calculateTotalExpenses();
                    break;
                case "4":
                    System.out.println(">>>>> Exiting the Expense Tracker. Goodbye!<<<<<");
                    return;
                default:
                    System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("\nSemicolon Expense Tracker");
        System.out.println("1. Add an expense");
        System.out.println("2. View all expenses");
        System.out.println("3. Calculate total expenses");
        System.out.println("4. Exit");
    }

    public static void addExpense() {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = input.nextLine();

        System.out.print("Enter description: ");
        String description = input.nextLine();

        System.out.print("Enter amount: ");
        try {
            double amount = Double.parseDouble(input.nextLine());
            expenses.add(new Expense(date, description, amount));
            System.out.println("Expense added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a number.");
        }
    }

    public  static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        System.out.println("\nExpenses:");
        System.out.printf("%-12s %-20s %-10s%n", "Date", "Description", "Amount");
        System.out.println("--------------------------------------------------");
        for (Expense expense : expenses) {
            System.out.printf("%-12s %-20s %-10.2f%n", expense.getDate(), expense.getDescription(), expense.getAmount());
        } 
    }

    public static void calculateTotalExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("Your total expenses is ₦ 0.00. You didn't spend today:");
            return;
        }

        double total = expenses.stream().mapToDouble(Expense::getAmount).sum();
        System.out.printf("Your total expenses is ₦ %.2f%n", total);
    }
}

public class Expense {
    public  final String date;
    public final String description;
    private final double amount;

    public Expense(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}
