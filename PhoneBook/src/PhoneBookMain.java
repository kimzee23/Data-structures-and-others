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
            System.out.println("4. Remove contact: ");
            System.out.println("5. Edit contact");
            System.out.println("6. EXIT  ");
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
                       System.out.println("Enter phone number you want to find ");
                       String searchContactWithNumber = input.nextLine();
                       userInput.FindContactByPhoneNumber(searchContactWithNumber);
                       if (searchContactWithNumber == null) {
                           System.out.println(searchContactWithNumber + "   Not found");
                       }else {
                           System.out.println(searchContactWithNumber);
                       }
                       break;
                       case 3:
                           System.out.println("Enter first name to Search: ");
                           String searchContactFirstName = input.nextLine();
                           PhoneBook search = userInput.FindContactByPhoneNumber(searchContactFirstName);

                           if (search == null) {
                               System.out.println("Contact not  found");
                           } else {
                               System.out.println(search.getFirstName() + " " + search.getLastName());
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
                                   System.out.println("Enter  contact to Remove");
                                   String removeContact = input.nextLine();
                                   boolean removed = userInput.removeContact(Integer.parseInt(removeContact));
                                   System.out.println("contact remove " + removed);
                                   break;
                                   case 6:
                                       System.out.println("Exit");
                                       break;
               default:
                   System.out.println("Invalid option");



           }
        }


    }
}
