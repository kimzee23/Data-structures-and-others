import java.util.Date;
import java.util.Scanner;

public class Menstruation {
    private String name;
    private int age;
    private int cycleLength;
    private Date lastPeriodStartDate;
<<<<<<< HEAD
=======
    private String flowDegree;
>>>>>>> 51280de (Initial commit)

    public Menstruation(String name, int age, int cycleLength, Date lastPeriodStartDate) {
        this.name = name;
        this.age = age;
        this.cycleLength = cycleLength;
        this.lastPeriodStartDate = lastPeriodStartDate;
<<<<<<< HEAD
=======

    }


    public void setUserName(String name) {

        this.name = name;
    }

    public void setUserAge(int age) {

        this.age = age;
    }

    public void setCycleLength(int cycleLength) {

        this.cycleLength = cycleLength;
    }

    public void setLastPeriodStartDate(Date lastPeriodStartDate) {

        this.lastPeriodStartDate = lastPeriodStartDate;
    }
    public void setFlowDegree(String flowDegree) {
        this.flowDegree = flowDegree;
>>>>>>> 51280de (Initial commit)
    }


    public String getUserName() {
        return name;
    }
<<<<<<< HEAD
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
=======

    public int getUserAge() {
        return age;
    }

    public int getCycleLength() {
        return cycleLength;
    }

    public Date getLastPeriodStartDate() {
        return lastPeriodStartDate;
    }

    public String getFlowDegree() {
        return flowDegree;
    }

>>>>>>> 51280de (Initial commit)


    public static Menstruation collectUserInput() {
        Scanner input = new Scanner(System.in);
        while (true) {
<<<<<<< HEAD

=======
>>>>>>> 51280de (Initial commit)
            System.out.print("Enter your name: ");
            String name = input.nextLine();
            if (!name.matches("[A-Za-z]+")) {
                continue;
            }

            System.out.print("Enter your age: ");
            int age = input.nextInt();
<<<<<<< HEAD
            if (age < 11 || age > 50 ) {
                System.out.println("you are too young or too old");
                continue;

=======
            if (age < 11 || age > 50) {
                System.out.println("You are too young or too old");
                continue;
>>>>>>> 51280de (Initial commit)
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

<<<<<<< HEAD


            Date lastPeriodStartDate = new Date(year - 1900, month - 1, day);

            return new Menstruation(name, age, cycleLength, lastPeriodStartDate);
        }
    }


=======
            System.out.println("Enter your flow degree: (light, moderate,low): )");
            String flowDegree = input.next().toLowerCase();
            if(!flowDegree.equals("light")&& !flowDegree.equals("moderate")&& !flowDegree.equals("low")) {
                System.out.println("Invalid flow degree, write in lower case");
                flowDegree = input.nextLine().toLowerCase();
            }

            Date lastPeriodStartDate = new Date(year - 1900, month - 1, day);
            Menstruation mentral =new Menstruation(name, age, cycleLength, lastPeriodStartDate);

            mentral.setFlowDegree(flowDegree);
            return mentral;
        }
    }

>>>>>>> 51280de (Initial commit)
    public Date calculateNextCycleDate() {
        long milliSecondInaDay = 24L * 60 * 60 * 1000;
        return new Date(lastPeriodStartDate.getTime() + cycleLength * milliSecondInaDay);
    }

<<<<<<< HEAD
=======

>>>>>>> 51280de (Initial commit)
    public boolean isLate() {
        Date today = new Date();
        return today.after(calculateNextCycleDate());
    }
<<<<<<< HEAD
=======
    public  void ShowAndCalculateSafeDate(){
        Date nextPeriodDate = calculateNextCycleDate();
        long milliSecondInADay = 24L * 60 * 60 * 1000;

        Date ovulationDate = new Date(nextPeriodDate.getTime() -14 * milliSecondInADay);
        Date UnsafeDaysBeings = new Date(ovulationDate.getTime() - 5 * milliSecondInADay);
        Date UnsafeDateDaysEnding = new Date(ovulationDate.getTime() -1 * milliSecondInADay);

        System.out.println("------ Safe Date ------");
        System.out.println("Ovulation date is: " + ovulationDate);
        System.out.println(" Unsafe day " + UnsafeDaysBeings + " to" + UnsafeDateDaysEnding);
        System.out.println("Safe Day:before " + UnsafeDaysBeings + "and later " + UnsafeDateDaysEnding );

    }
>>>>>>> 51280de (Initial commit)

    public void showCycleInfo() {
        System.out.println("\n--- Menstruation Information ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Cycle Length: " + cycleLength + " days");
        System.out.println("Last Period Start Date: " + lastPeriodStartDate);
<<<<<<< HEAD
        System.out.println("Next Expected Period: " + calculateNextCycleDate());
        System.out.println("Is your period late? " + (isLate() ? "Yes" : "No"));
=======
        System.out.println("When to Expect Period next: " + calculateNextCycleDate());
        System.out.println("Is your period late? " + (isLate() ? "Yes" : "No"));
        ShowAndCalculateSafeDate();

>>>>>>> 51280de (Initial commit)
    }

    public static void main(String[] args) {
        Menstruation userMenstruationCycle = Menstruation.collectUserInput();
        userMenstruationCycle.showCycleInfo();
    }
<<<<<<< HEAD


=======
>>>>>>> 51280de (Initial commit)
}
