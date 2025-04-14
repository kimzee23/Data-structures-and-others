import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class MenstruationTest {
    @Test
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
        Menstruation period = new Menstruation("Ope", 25, 0, new Date());
        assertEquals(false, period.isLate(), "Late should be true");
    }
    @Test
    public void testGetAndSetFlowDegree(){
        Menstruation period = new Menstruation("Ope", 25, 0, new Date());
        Date date = new Date(2023 - 1925, 3,1);
        period.setUserName("Ope");

        period.setFlowDegree("light");
        String actualDegree = period.getFlowDegree();
        assertEquals("light", actualDegree,"flow Degree should be light");
    }
//    @Test
//    public void testGetInvalidFlowDegree() {
//        Menstruation period = new Menstruation("Ope", 30, 0, new Date());
//        period.getFlowDegree("Invalid");
//        assertEquals("Invalid", period.getFlowDegree(), "flow Degree should be invalid");
//
//    }

}
