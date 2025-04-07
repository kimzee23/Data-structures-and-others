import java.util.Date;
import java.util.Scanner;

public class Menstruation {
    private String name;
    private int age;
    private int cycleLength;
    private Date lastPeriodStartDate;

    public Menstruation(String name, int age, int cycleLength, Date lastPeriodStartDate) {
        this.name = name;
        this.age = age;
        this.cycleLength = cycleLength;
        this.lastPeriodStartDate = lastPeriodStartDate;
    }


    public String getUserName() {
        return name;
    }
    public int getUserAge() {

        return age;
    }
    public int getCycleLength() {
        return cycleLength;
    }
    public Date getLastPeriodStartDate() {

        return lastPeriodStartDate;
    }

    public void getUserName(String name) {

        this.name = name;
    }
    public void getUserAge(int age) {

        this.age = age;
    }
    public void getCycleLength(int cycleLength) {

        this.cycleLength = cycleLength;
    }
    public void setLastPeriodStartDate(Date date) {

        this.lastPeriodStartDate = date;
    }


    public static Menstruation collectUserInput() {
        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.print("Enter your name: ");
            String name = input.nextLine();
            if (!name.matches("[A-Za-z]+")) {
                continue;
            }

            System.out.print("Enter your age: ");
            int age = input.nextInt();
            if (age < 11 || age > 50 ) {
                System.out.println("you are too young or too old");
                continue;

            }

            System.out.print("Enter your cycle length in days (e.g., 28): ");
            int cycleLength = input.nextInt();
            if (cycleLength < 21 || cycleLength > 30) {
                System.out.println("Invalid cycle length");
                continue;
            }

            System.out.println("Enter your last period start date:");
            System.out.print("  Month (1-12): ");
            int month = input.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Invalid month input");
                continue;
            }

            System.out.print("  Day: ");
            int day = input.nextInt();
            if (day < 1 || day > 31) {
                System.out.println("Invalid day input");
                continue;
            }

            System.out.print("  Year: ");
            int year = input.nextInt();



            Date lastPeriodStartDate = new Date(year - 1900, month - 1, day);

            return new Menstruation(name, age, cycleLength, lastPeriodStartDate);
        }
    }


    public Date calculateNextCycleDate() {
        long milliSecondInaDay = 24L * 60 * 60 * 1000;
        return new Date(lastPeriodStartDate.getTime() + cycleLength * milliSecondInaDay);
    }

    public boolean isLate() {
        Date today = new Date();
        return today.after(calculateNextCycleDate());
    }

    public void showCycleInfo() {
        System.out.println("\n--- Menstruation Information ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Cycle Length: " + cycleLength + " days");
        System.out.println("Last Period Start Date: " + lastPeriodStartDate);
        System.out.println("Next Expected Period: " + calculateNextCycleDate());
        System.out.println("Is your period late? " + (isLate() ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        Menstruation userMenstruationCycle = Menstruation.collectUserInput();
        userMenstruationCycle.showCycleInfo();
    }


}
