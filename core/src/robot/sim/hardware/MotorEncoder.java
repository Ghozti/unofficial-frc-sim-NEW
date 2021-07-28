package robot.sim.hardware;

public class MotorEncoder {

    //fields
    private Motor assignedMotor;
    private float id;
    private MotorEncoder master;

    /*CONSTRUCTORS*/

    public MotorEncoder(Motor assignedMotor, float id){
        this.assignedMotor = assignedMotor;
        this.id = id;
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

    /*SETTERS*/

    public void setSpeed(float speed){
        assignedMotor.setCurrentPower(1);
    }

    public void setSpeed(MotorEncoder encoder){
        assignedMotor.setCurrentPower(encoder.getAssignedMotor().getCurrentPower());
    }
}
