import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class PhoneBookMain {
    public static void main (String[] args) {
        PhoneBookMethod userInput = new PhoneBookMethod();
        Scanner input = new Scanner(System.in);

        while (true) {
//            System.out.println();
            input.nextLine();
            System.out.println("------- Azfeez Phone Book management ------- ------");
            System.out.println("1. Add contact");
            System.out.println("2. Find contact by phone number: ");
            System.out.println("3. Find contact by first name");
            System.out.println("4. Edit contact");
            System.out.println("5. Remove contact: ");
            System.out.println("6. View contacts: ");
            System.out.println("7. EXIT  ");
            System.out.print("Enter an option: ");
            int option = Integer.parseInt(input.nextLine());
           switch (option) {
               case 1:
                   System.out.println("Enter first name: ");
                   String firstName = input.nextLine();
                   System.out.println("Enter last name: ");
                   String lastName = input.nextLine();
                   System.out.println("Enter phone number: ");
                   String phoneNumber = input.nextLine();
                   userInput.addContact(new PhoneBook(firstName, lastName, phoneNumber));
                   System.out.println("Contact added successfully");
                   break;
               case 2:
                   System.out.println("Enter phone number you want to find: ");
                   String searchContactWithNumber = input.nextLine();
                   PhoneBook findContact = userInput.FindContactByPhoneNumber(searchContactWithNumber);
                   if (findContact == null) {
                       System.out.println("Contact not found.");
                   } else {
                       System.out.println("Contact found: " + findContact);
                   }
                   break;

               case 3:
                   System.out.println("Enter first name to search: ");
                   String searchContactFirstName = input.nextLine();
                   List<PhoneBook> ifIsTheSame = userInput.findFirstName(searchContactFirstName);
                   if (ifIsTheSame.isEmpty()) {
                       System.out.println("No contacts found with the name: " + searchContactFirstName);
                   } else {
                       System.out.println(" contacts found :");
                       for (PhoneBook contact : ifIsTheSame) {
                           System.out.println(contact);
                       }
                   }
                   break;

               case 4:
                   System.out.print("Enter phone number of contact to edit: ");
                   String oldPhoneNumber = input.nextLine();
                   System.out.println("Enter first name to edit:");
                   String editContactFirstName = input.nextLine();
                   System.out.println("Enter last name to edit:");
                   String editContactLastName = input.nextLine();
                   System.out.println("Enter phone number to edit:");
                   String editContactPhoneNumber = input.nextLine();
                   userInput.editContact(oldPhoneNumber,editContactFirstName,editContactLastName,editContactPhoneNumber);
                   System.out.println("Contact edited successfully");
                   break;
                        case 5:
                        System.out.println("Are you sure you want to remove all contacts? (yes/no)");
                        String confirmation = input.nextLine();
                        if (confirmation.equalsIgnoreCase("yes")) {
                        userInput.removeAllContacts();
                        System.out.println("All contacts have been removed.");
                   } else {
                       System.out.println("Operation cancelled.");
                   }
                   break;
               case 6:
                   userInput.viewAllContact();
                   break;


               case 7:
                   System.out.println("Exit");
                   break;
               default:
                   System.out.println("Invalid option");



           }
        }


    }
}
