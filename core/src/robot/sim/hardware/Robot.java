package robot.sim.hardware;

public class Robot {

    float currentSpeed;
    String name;
    Chassis chassis;
    float width = 18f, length = 30f;

    public Robot(String name){
        this.name = name;
        currentSpeed = 0;
    }

    public void buildChassis(Chassis chassis){
        this.chassis = chassis;

        /*
                                  FRONT
                            ________________
                     LEFT   |               |   RIGHT
                          0 |               | 0
                          1 |     robot     | 1
                          2 |               | 2
                            |               |
                            -----------------
                                  BACK
         */

        chassis.addLeftSideEncoder(new MotorEncoder(new Motor(),0));
    }

    public void driveForward(){

    }
}
