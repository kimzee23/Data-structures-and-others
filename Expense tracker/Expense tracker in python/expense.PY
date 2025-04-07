import re
from datetime import datetime

def display_menu():
    print("\nSemicolon Expense Tracker")
    print("1. Add an expense")
    print("2. View all expenses")
    print("3. Calculate total expenses")
    print("4. Exit \U0001F600")


def validate_date(date_string: str) -> bool:
    """Validates the date string using regex and datetime parsing."""
    date_pattern = re.compile(r"^\d{4}-\d{2}-\d{2}$")  # YYYY-MM-DD

    if not date_pattern.match(date_string):
        return False

    try:
        datetime.strptime(date_string, "%Y-%m-%d")
        return True
    except ValueError:  # Catches invalid dates like 2023-02-30
        return False



def add_expense(expenses, date, description, amount):
    """Adds an expense to the expenses list after validating date and amount."""
    if not validate_date(date):
        return "Invalid date format. Please use YYYY-MM-DD."

    try:
        amount = float(amount)
        expenses.append([date, description, amount])
        return "Expense added successfully!"
    except ValueError:
        return "Invalid amount. Please enter a number."


def view_expenses(expenses):
    """Displays all recorded expenses in a formatted table."""
    if not expenses:
        return "No expenses recorded."

    output = "\nExpenses:\n"
    output += f"{'Date':<12} {'Description':<20} {'Amount':<10}\n"
    output += "-" * 50 + "\n"
    for expense in expenses:
        output += f"{expense[0]:<12} {expense[1]:<20} {expense[2]:<10.2f}\n"
    return output


def calculate_total_expenses(expenses):
    """Calculates and returns the total expenses."""
    if not expenses:
        return "Your total expenses is \u20A6 0.00. You didn't spend today:"

    total = sum(expense[2] for expense in expenses if len(expense) > 2 and isinstance(expense[2], (int, float)))

    return f"Your total expenses is \u20A6 {total:.2f}"


def main_test():
    expenses = []
    while True:
        display_menu()
        choice = input("Choose an option (1-4): ")

        if choice == "1":
            date = input("Enter date (YYYY-MM-DD): ")
            description = input("Enter description: ")
            amount = input("Enter amount: ")
            print(add_expense(expenses, date, description, amount))  # Changed this line

        elif choice == "2":
            print(view_expenses(expenses))

        elif choice == "3":
            print(calculate_total_expenses(expenses))

        elif choice == "4":
            print(">>>>>Exiting the Expense Tracker. Goodbye!")
            break

        else:
            print("Invalid Input. Please try again.")


if __name__ == "_main_":
    main_test()