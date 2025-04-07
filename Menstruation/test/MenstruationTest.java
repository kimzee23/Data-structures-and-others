import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class MenstruationTest {
    @Test
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

    }



}
