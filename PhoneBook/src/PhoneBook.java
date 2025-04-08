
public class PhoneBook {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public PhoneBook(String firstName, String LastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = LastName;
        this.phoneNumber = phoneNumber;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String toString(){
        return firstName + " " + lastName + " " + phoneNumber;
    }


}
