package robot.sim.hardware;

public class Motor {

    //constants
    private final float maxPower = 1;
    private final float maxRPM = 5675;

    //fields
    private float currentPower;
    private float currentSpeed;
    private boolean inverted;

    public float getMaxPower(){return maxPower;}
    public float getMaxRPM(){return maxRPM;}

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
