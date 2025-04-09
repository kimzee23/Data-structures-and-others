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
        for(PhoneBook removeNumber : phoneBooks ){
            if (removeNumber.getPhoneNumber().equals(remove)){
                phoneBooks.remove(removeNumber);
                return true;
            }
        }
        return false;
    }

    public PhoneBook FindContactByPhoneNumber(String PhoneNumber) {
        for (PhoneBook find : phoneBooks) {
            if (find.getPhoneNumber().equals(PhoneNumber)) {
              System.out.println("this is the details : " +  find);
                return find;
            }
        }
        return null;
    }

    public List<PhoneBook> findFirstName(String firstName) {
        List<PhoneBook> result = new ArrayList<>();
        for (PhoneBook contact : phoneBooks) {
            if (contact.getFirstName()==(firstName)) {
                result.add(contact);
            }
        }
        return result;
    }

    public List<PhoneBook> findLastName(String lastName) {
        List<PhoneBook> result = new ArrayList<>();
        for (PhoneBook contact : phoneBooks) {
            if (contact.getLastName()==(lastName)) {
                result.add(contact);
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

    }
