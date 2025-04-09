import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class MenstruationTest {
    @Test
<<<<<<< HEAD
    public void testUserGetters() {
        String name = "Ade";
        int age = 13;
        int cycleLength = 4;
        Date lastPeriodStartDate = new Date();



        Menstruation period = new Menstruation( name,  age, cycleLength, lastPeriodStartDate);
        assertEquals("Ade",period.getUserName(),"Enter your name ");
        assertEquals(13,period.getUserAge(),"Enter your Age");
        assertEquals(4,period.getCycleLength(),"Enter your menstrual cycle length");
        assertEquals(lastPeriodStartDate,period.getLastPeriodStartDate(),"Enter your last period start date");





    }
    @Test
    public void testUserSetters() {
        Menstruation period = new Menstruation(  "Ade",13,4,new Date());
        period.getUserName("Ade");
        period.getUserAge(13);
        period.getCycleLength(35);
        period.setLastPeriodStartDate(new Date());

        assertEquals("Ade",period.getUserName(),"get name ");
        assertEquals(13,period.getUserAge(),"get Age");
        assertEquals(35,period.getCycleLength(),"get days cycle length");
        assertEquals(new Date(),period.getLastPeriodStartDate());
=======
    public void testUserSettersAndGetters() {
        Date date = new Date();
        Menstruation period = new Menstruation("Name", 0, 0, date);

        period.setUserName("Suliya");
        period.setUserAge(13);
        period.setCycleLength(28);
        period.setLastPeriodStartDate(date);

        assertEquals("Suliya", period.getUserName(), "Name should be 'Ade'");
        assertEquals(13, period.getUserAge(), "Age should be 13");
        assertEquals(28, period.getCycleLength(), "Cycle length should be 28");
        assertEquals(date, period.getLastPeriodStartDate(), "Date should match");
    }
    @Test
    public void testCalculateNextCycleDate() {

        int cycleLength = 28;
        Date lastPeriodStartDate = new Date();

        Menstruation period = new Menstruation("Ope", 25, cycleLength, lastPeriodStartDate);
        Date expectedNextCycleDate = new Date(lastPeriodStartDate.getTime() + (long) cycleLength * 24 * 60 * 60 * 1000);

        assertEquals(expectedNextCycleDate, period.calculateNextCycleDate(), "Next cycle date should be 28 days from last start date");
    }
    @Test
    public void testIfMenstruationComesLate() {
        int cycleLength = 28;
        Date lastPeriodStartDate = new Date();
        Menstruation period = new Menstruation("Jane", 25, 0, new Date());

>>>>>>> 51280de (Initial commit)

    }



<<<<<<< HEAD
=======

>>>>>>> 51280de (Initial commit)
}
