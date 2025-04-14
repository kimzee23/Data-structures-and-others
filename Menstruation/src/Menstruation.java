import java.util.Date;

public class Menstruation {
    private String name;
    private int age;
    private int cycleLength;
    private Date lastPeriodStartDate;
    private String flowDegree;

    public Menstruation(String name, int age, int cycleLength, Date lastPeriodStartDate) {
        this.name = name;
        this.age = age;
        this.cycleLength = cycleLength;
        this.lastPeriodStartDate = lastPeriodStartDate;
    }

    public void setUserName(String name) {
        if()

    }
    public void setUserAge(int age) {
        this.age = age;
    }
    public void setCycleLength(int cycleLength) { this.cycleLength = cycleLength; }
    public void setLastPeriodStartDate(Date lastPeriodStartDate) { this.lastPeriodStartDate = lastPeriodStartDate; }
    public void setFlowDegree(String flowDegree) { this.flowDegree = flowDegree; }

    public String getUserName() { return name; }
    public int getUserAge() { return age; }
    public int getCycleLength() { return cycleLength; }
    public Date getLastPeriodStartDate() { return lastPeriodStartDate; }
    public String getFlowDegree() { return flowDegree; }

    public Date calculateNextCycleDate() {
        long milliSecondInaDay = 24L * 60 * 60 * 1000;
        return new Date(lastPeriodStartDate.getTime() + cycleLength * milliSecondInaDay);
    }

    public boolean isLate() {
        Date today = new Date();
        return today.after(calculateNextCycleDate());
    }

    public void ShowAndCalculateSafeDate() {
        Date nextPeriodDate = calculateNextCycleDate();
        long milliSecondInADay = 24L * 60 * 60 * 1000;

        Date ovulationDate = new Date(nextPeriodDate.getTime() - 14 * milliSecondInADay);
        Date unsafeStart = new Date(ovulationDate.getTime() - 5 * milliSecondInADay);
        Date unsafeEnd = new Date(ovulationDate.getTime() - 1 * milliSecondInADay);

        System.out.println("==== Safe Date =====");
        System.out.println("Ovulation date is: " + ovulationDate);
        System.out.println("Unsafe days: " + unsafeStart + " to " + unsafeEnd);
        System.out.println("Safe Days: Before " + unsafeStart + " and after " + unsafeEnd);
    }

    public void showCycleInfo() {
        System.out.println("\n===== Menstruation Information =====");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Cycle Length: " + cycleLength + " days");
        System.out.println("Last Period Start Date: " + lastPeriodStartDate);
        System.out.println("Next Expected Period: " + calculateNextCycleDate());
        System.out.println("Is your period late? " + (isLate() ? "Yes" : "No"));
        ShowAndCalculateSafeDate();
        System.out.println("\n===== Kindly buy original Menstruation pad =====");
        System.out.printf("""
                --- Good Menstruation pad brands ---
                1. Always Pure Cotton with FlexFoam Pads
                2. Peesafe organic regular sanitary pads
                3. Stayfree secure cotton sanitary pads
                4. Whisper Ultra Soft Air dry Pads
                5. Azah cotton sanitary pads
                6. Always
                """);
    }
}
