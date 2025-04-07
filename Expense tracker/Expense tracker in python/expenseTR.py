import re
def display_menu():
    print("\nSemicolon Expense Tracker")
    print("1. Add an expense")
    print("2. View all expenses")
    print("3. Calculate total expenses")
    print("4. Exit :\U0001F600")




def add_expense(expenses, date, description, amount):

    try:
        amount = float(amount)
        date = re.findall("2025-31-12", date)
        expenses.append([date, description, amount])
        return "Expense added successfully!"
    except ValueError:
        return "Invalid amount or Date entered . Please enter a number."


def view_expenses(expenses):
    if not expenses:
        return "No expenses recorded."
    output = "\nExpenses:\n"
    output += f"{'Date':<12} {'Description':<20} {'Amount':<10}\n"
    output += "-" * 50 + "\n"
    for expense in expenses:
        output += f"{expense[0]:<12} {expense[1]:<20} {expense[2]:<10.2f}\n"
    return output
def calculate_total_expenses(expenses):
    if not expenses:
        return "Your total expenses is #0.00 You did not spend anything ode :"
    
    total = sum(expense[2] for expense in expenses if len(expense) > 2 and isinstance(expense[2], (int, float)))
    
    return f"Your total expenses is #{total:.2f}"


def main_test():
    expenses = []
    while True:
        display_menu()
        choice = input("Choose an option (1-4): ")
        if choice == "1":
            date = input("Enter date (YYYY-MM-DD): ")
            description = input("Enter description: ")
            amount = input("Enter amount: ")
            print(add_expense(expenses, date, description, amount))
        elif choice == "2":
            print(view_expenses(expenses)) 
        elif choice == "3":
            print(add_expense(expenses, date, description, amount))
            print(calculate_total_expenses(expenses))
        elif choice == "4":
            print(">>>>>Exiting the Expense Tracker. Goodbye!")
            break
        else:
            print("Invalid Input. Please try again.")
if __name__ == "__main__":
   	main_test()
