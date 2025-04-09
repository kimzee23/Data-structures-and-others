import java.util.ArrayList;
import java.util.List;

public class PhoneBookMethod {
    private final List<PhoneBook> phoneBooks;

    public PhoneBookMethod() {
        phoneBooks = new ArrayList<>();

    }
    public void addContact(PhoneBook phoneBook) {
        phoneBooks.add(phoneBook);
    }

    public List<PhoneBook> getAllContacts() {
        return phoneBooks;
    }

    public boolean removeContact(int remove) {
        for(int count = 0; count < phoneBooks.size(); count++ ) {
            PhoneBook removeNumber = phoneBooks.get(count);
            if (removeNumber.getPhoneNumber().equals(remove)){
                phoneBooks.remove(removeNumber);
                return true;
            }
        }
        return false;
    }

    public PhoneBook FindContactByPhoneNumber(String PhoneNumber) {
        for (int count = 0; count < phoneBooks.size(); count++) {
            PhoneBook find = phoneBooks.get(count);
            if (find.getPhoneNumber().equals(PhoneNumber)) {
              System.out.println("this is the details : " +  find);
                return find;
            }
        }
        return null;
    }

    public List<PhoneBook> findFirstName(String firstName) {
        List<PhoneBook> matches = new ArrayList<>();

        for (int count = 0; count < phoneBooks.size(); count++) {
            PhoneBook phoneBook = phoneBooks.get(count);
            if (phoneBook.getFirstName().equalsIgnoreCase(firstName)) {
                matches.add(phoneBook);
            }
        }

        return matches;
    }


    public List<PhoneBook> findLastName(String lastName) {
        List<PhoneBook> result = new ArrayList<>();
        for (int count = 0; count < phoneBooks.size(); count++) {
            PhoneBook phoneBook = phoneBooks.get(count);
            if (phoneBook.getLastName()==(lastName)) {
                result.add(phoneBook);
            }
        }
        return result;
    }
    public boolean editContact(String newPhoneNumber, String newFirstName, String newLastName, String oldPhoneNumber) {
        for (int count = 0; count < phoneBooks.size(); count++) {
            PhoneBook contact = phoneBooks.get(count);
            if (contact.getPhoneNumber()==(oldPhoneNumber)) {
                PhoneBook updatedContact = new PhoneBook(newFirstName, newLastName, newPhoneNumber);
                phoneBooks.set(count, updatedContact);
                return true;
            }
        }
        return false;
    }

    public void removeAllContacts() {
        phoneBooks.clear();
    }
    public void viewAllContact(){
        if (phoneBooks.isEmpty()){
            System.out.println("No phone books found");
        }
        for (int count = 0 ; count < phoneBooks.size(); count++) {
            PhoneBook theCount = phoneBooks.get(count);
            System.out.println(theCount);
        }
    }
}
