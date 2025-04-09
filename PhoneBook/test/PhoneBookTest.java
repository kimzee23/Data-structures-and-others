import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PhoneBookTest {


    @Test
    public void testAddConstructor() {
        PhoneBook information = new PhoneBook("Ade","Yemi", "1234567890");
        String expected = "1234567890";

        assertEquals("Ade", information.getFirstName(),"Enter first name");
        assertEquals("Yemi",information.getLastName(),"Enter last name");
        assertEquals(expected,information.getPhoneNumber(), "Enter phone number");





    }
    @Test

    public void testAddContacts() {

            PhoneBook contact = new PhoneBook("Ade", "Yemi", "1234567890");
        PhoneBookMethod phoneBookContact = new PhoneBookMethod();
            phoneBookContact.addContact(contact);
            List<PhoneBook> contacts = phoneBookContact.getAllContacts();


            assertEquals(1, contacts.size());
            assertEquals("Ade", contacts.get(0).getFirstName());
            assertEquals("Yemi", contacts.get(0).getLastName());
            assertEquals("1234567890", contacts.get(0).getPhoneNumber());
        }
    @Test
    public void testRemoveContact() {
        PhoneBook contact = new PhoneBook("Ade","Yemi", "1234567890");
        PhoneBookMethod phoneBookContact = new PhoneBookMethod();

        boolean removed = phoneBookContact.removeContact(1234567890);

        assertFalse(removed, "Contact was not removed");

    }
    @Test
    public void testFindContactByNumber() {
        PhoneBook contact = new PhoneBook("Ade","Yemi", "1234567890");

        PhoneBookMethod phoneBookContact = new PhoneBookMethod();

        PhoneBook removedContact=phoneBookContact.FindContactByPhoneNumber("123456789");
        assertNull(removedContact);
    }
    @Test
    public void testFindContactByPhoneNumber() {
        PhoneBook contact = new PhoneBook("Ade","Yemi", "1234567890");
        PhoneBookMethod phoneBookContact = new PhoneBookMethod();

        PhoneBook removedContact=phoneBookContact.FindContactByPhoneNumber("1234567890");

        assertNull(removedContact);
        assertEquals("Ade", contact.getFirstName());
        assertEquals("Yemi", contact.getLastName());

    }
    @Test
    public void testFindFirstName() {

        PhoneBookMethod phoneBookManager = new PhoneBookMethod();
        PhoneBook contact = new PhoneBook("Ade", "Yemi", "1234567890");
        phoneBookManager.addContact(contact);

        List<PhoneBook> firstNameContact = phoneBookManager.findFirstName("Ade");
        assertEquals(1, firstNameContact.size());
        assertEquals("Yemi", firstNameContact.get(0).getLastName());
    }
    @Test
    public void testFindLastName() {
        PhoneBookMethod phoneBookManager = new PhoneBookMethod();
        PhoneBook contact = new PhoneBook("Ade", "Yemi", "1234567890");
        phoneBookManager.addContact(contact);

        List<PhoneBook> lastNameContact = phoneBookManager.findLastName("Yemi");
        assertEquals(1, lastNameContact.size());
        assertEquals("Yemi", lastNameContact.get(0).getLastName());

    }
    @Test
    public void testEditContact() {
            PhoneBookMethod phoneBookContact = new PhoneBookMethod();
            PhoneBook contact = new PhoneBook("Ade", "Yemi", "1234567890");
            phoneBookContact.addContact(contact);

            boolean edited = phoneBookContact.editContact("0987654321", "Ade", "Yemi", "1234567890");

            assertTrue(edited);
            PhoneBook updated = phoneBookContact.FindContactByPhoneNumber("0987654321");
            assertEquals("Ade", updated.getFirstName());
            assertEquals("Yemi", updated.getLastName());
        }



}
