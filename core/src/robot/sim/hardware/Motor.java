package robot.sim.hardware;

public class Motor {

    //constants
    private final float maxPower = 1;
    private final float maxSpeed = 10;//in pixels
    private final float climb = 2000;// 2 seconds to go from 0 to 10 in pixels

    //fields
    private float currentPower;
    private float currentSpeed;
    private boolean inverted;

    public float getMaxPower(){return maxPower;}
    public float getCurrentPower(){return currentPower;}
    public float getCurrentSpeed(){return currentSpeed;}
    public boolean getInverted(){return inverted;}

    public void setCurrentPower(float p){
        currentPower = p;
    }

    public void setInverted(boolean inverted){
        this.inverted = inverted;
    }
}
