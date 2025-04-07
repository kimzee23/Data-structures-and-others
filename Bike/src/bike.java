public class bike {
    private int engineOn ;
    private int engineOff ;
    private int speed ;
    private int gear ;

    private int gearOneIncrease = 20;

    public bike(int engineOn, int engineOff) {
        this.engineOn = 1;
        this.engineOff = 0;
        this.speed = 0;
        this.gear = 1;


    }


    public int engineOn() {
        if (engineOn == 0) {
            engineOn = 1;
        }
        return engineOn;
    }


    public int engineOff() {
        if (engineOff == 1) {
            engineOff = 0;

        }
        return engineOff;
    }

    public int setEngineGear(int newAccelerationGear) {
        if (engineOn == 0) {
            System.out.println("The bike engine is not running ");
            return 0;
        }if (newAccelerationGear > 1 && newAccelerationGear <=4) {
            this.gear = newAccelerationGear;
        }else {
            System.out.println("Kindly Set a gear ");
        }
        return gear;
    }

    public int engineSpeed() {
        if (engineOn == 0) {
            System.out.println("Can't speed the engine is no On ");
            return 0;
        }
        gear += speed;
        return gear;
    }

    public int setEngineDeceleration(int newDecelerationGear) {
        return engineOn;
    }
}
