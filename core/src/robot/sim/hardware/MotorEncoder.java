package robot.sim.hardware;

public class MotorEncoder {

    //fields
    Motor assignedMotor;
    float id;
    MotorEncoder master;

    public MotorEncoder(Motor assignedMotor, float id){
        this.assignedMotor = assignedMotor;
        this.id = id;
    }

    public MotorEncoder(Motor assignedMotor, float id,MotorEncoder masterMotorEncoder){
        this.assignedMotor = assignedMotor;
        this.id = id;
        master = masterMotorEncoder;
    }
}
