package robot.sim.hardware;

import java.util.ArrayList;

public class Chassis {

    //FIELDS
    String chassisType;

    ArrayList<MotorEncoder> rightSideEncoders = new ArrayList<>();
    ArrayList<MotorEncoder> leftSideEncoders = new ArrayList<>();

    //CONSTRUCTOR
    public Chassis(String chassisType){
        this.chassisType = chassisType;
    }

    //METHODS
    public void addRightEncoders(MotorEncoder encoder){
        rightSideEncoders.add(encoder);
    }

    public void addLeftSideEncoder(MotorEncoder encoder){
        leftSideEncoders.add(encoder);
    }

    public void setRightSideEncodersSpeed(MotorEncoder master){
        for(MotorEncoder e : rightSideEncoders){
            e.setSpeed(master.getSpeed());
        }
    }

    public void setLeftSideEncodersSpeed(MotorEncoder master){
        for(MotorEncoder e : leftSideEncoders){
            e.setSpeed(master.getSpeed());
        }
    }
}
