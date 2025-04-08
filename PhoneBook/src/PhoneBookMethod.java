import java.util.ArrayList;
import java.util.List;

public class PhoneBookMethod {
    private List<PhoneBook> phoneBooks;

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
                return find;
            }
        }
        return null;
    }

    public List<PhoneBook> findFirstName(String firstName) {
        List<PhoneBook> result = new ArrayList<>();
        for (PhoneBook contact : phoneBooks) {
            if (contact.getFirstName().equals(firstName)) {
                result.add(contact);
            }
        }
        return result;
    }

    public List<PhoneBook> findLastName(String lastName) {
        List<PhoneBook> result = new ArrayList<>();
        for (PhoneBook contact : phoneBooks) {
            if (contact.getLastName().equals(lastName)) {
                result.add(contact);
            }
        }
        return result;
    }

    public boolean editContact(String PhoneNumber,String newFirstName, String newLastName, String newPhoneNumber) {
        for(PhoneBook phoneBook : phoneBooks){
            if (phoneBook.getPhoneNumber().equals(PhoneNumber)) {
                phoneBook = new PhoneBook(newFirstName,newLastName,newPhoneNumber);
            }
        }
        return false;
    }
}
