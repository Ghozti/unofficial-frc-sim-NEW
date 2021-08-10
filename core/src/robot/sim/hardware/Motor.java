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

    //10 px per sec
    //5px in half sec
    //2.5 in 1/4 sec

    public void updateSpeed(float delta){
        System.out.println(delta);//TODO make this update acoordingly to it's side. this means that even if the dekta reaches 1500 for the right side the delta time has to reset if the other side is pressed
        if(delta <= .5){
            currentSpeed = 2.5f;
        }
        if (delta <= 1.0 && delta > .5){
            currentSpeed = 5;
        }
        if (delta <= 1.5 && delta > 1.0){
            currentSpeed = 7.5f;
        }
        if (delta <= 2.0 && delta > 1.5){
            currentSpeed = 10;
        }
    }

    public void setCurrentPower(float p){
        currentPower = p;
    }

    public float getInvertedSpeed(){
        inverted = true;
        return -currentSpeed;
    }
}
