package robot.sim.hardware;

public class MotorEncoder {

    //fields
    private Motor assignedMotor;
    private float id;
    private MotorEncoder master;
    private boolean masterEncoder;

    /*CONSTRUCTORS*/

    public MotorEncoder(Motor assignedMotor, float id){
        this.assignedMotor = assignedMotor;
        this.id = id;
        masterEncoder = true;
    }

    public MotorEncoder(Motor assignedMotor, float id,MotorEncoder masterMotorEncoder){
        this.assignedMotor = assignedMotor;
        this.id = id;
        master = masterMotorEncoder;
    }

    /*GETTERS*/

    public Motor getAssignedMotor(){
        return assignedMotor;
    }

    public float getId(){
        return id;
    }

    public MotorEncoder getMaster(){
        return master;
    }

    public float getSpeed(){
        return assignedMotor.getCurrentSpeed();
    }

    /*SETTERS*/

    public void setSpeed(float speed){
        assignedMotor.setCurrentPower(speed);
    }

}
