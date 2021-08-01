package robot.sim.hardware;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

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

        /*  ROBOT VISUALIZE
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

        //LEFT SIDE
        chassis.addLeftSideEncoder(new MotorEncoder(new Motor(),0));
        chassis.addLeftSideEncoder(new MotorEncoder(new Motor(),1));
        chassis.addLeftSideEncoder(new MotorEncoder(new Motor(),2));

        //RIGHT SIDE
        chassis.addRightEncoders(new MotorEncoder(new Motor(), 0));
        chassis.addRightEncoders(new MotorEncoder(new Motor(), 1));
        chassis.addRightEncoders(new MotorEncoder(new Motor(), 2));
    }

    public void handleInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){

        }
    }

    public void driveForward(){// ^
        chassis.leftSideEncoders.get(0).setSpeed(1);
        chassis.setLeftSideEncodersSpeed(chassis.leftSideEncoders.get(0));

        chassis.rightSideEncoders.get(0).setSpeed(1);
        chassis.setRightSideEncodersSpeed(chassis.rightSideEncoders.get(0));
    }

    public void driveBack(){//V

    }

    public void driveRight(){//>

    }

    public void driveLeft(){//<

    }
}
