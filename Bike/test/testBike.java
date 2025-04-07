import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testBike {
    @Test
    @DisplayName("Run bike engine and off bike engine   ")
    public void testBikeConstructor() {
        bike rider = new bike(1, 0);
        assertEquals(1, rider.engineOn(), "The bike engine is running ");
        assertEquals(0, rider.engineOff(), "The bike engine is Off");

    }
    @Test
    @DisplayName("set bike acceleration ")
    public void testBikeEngineGear() {
        bike rider = new bike(1, 0);
        rider.engineOn();
        int setting = rider.setEngineGear(2);
        assertEquals(2, setting, "The bike is set to gear 2 ");

    }
    @Test
    public void testBikeEngineSpeed() {
        bike rider = new bike(1, 0);
        rider.engineOn();
        int engineSpeed= rider.engineSpeed();
        assertEquals(2, engineSpeed, "The bike engine is running ");
    }
    @Test
    @DisplayName("set gear 3")
    public void testBikeSerGearThree() {
        bike rider = new bike(1, 0);
        rider.engineOn();
        int setting = rider.setEngineGear(3);
        assertEquals(3, setting, "The bike is set to gear 3 ");
    }
    @Test
    @DisplayName("set to gear 4")
    public void testBikeSerGearFour() {
        bike rider = new bike(1, 0);
        rider.engineOn();
        int setting = rider.setEngineGear(4);
        assertEquals(4, setting, "The bike is set to gear 4 ");
    }
    @Test
    @DisplayName("set bike deceleration")
    public void testBikeDeceleration() {
        bike rider = new bike(1, 0);
        rider.engineOn();
        int decelerationSettings = rider.setEngineDeceleration(-2);
        assertEquals(-2, decelerationSettings, "The bike is set to deceleration ");


    }

}
