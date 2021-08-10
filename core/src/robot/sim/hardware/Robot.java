package robot.sim.hardware;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Robot {

    float currentSpeed;
    String name;
    Chassis chassis;

    //graphics
    Texture texture;
    float x,y;
    float width = 100f, length = 100f;

    public Robot(String name){
        this.name = name;
        currentSpeed = 0;
        texture = new Texture("sol.png");
    }

    public Texture getTexture(){
        return texture;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public float getWidth(){
        return width;
    }

    public float getLength(){
        return length;
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

    private String lastPressed = "";

    public void handleInput(float delta){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            if (!lastPressed.equals("w")){
                chassis.rightSideEncoders.get(0).getAssignedMotor().resetSpeed();
                chassis.leftSideEncoders.get(0).getAssignedMotor().resetSpeed();
            }
            lastPressed = "w";
            chassis.rightSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            chassis.leftSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            y += chassis.leftSideEncoders.get(0).getSpeed() + chassis.rightSideEncoders.get(0).getSpeed();// TODO work on encoders to manipulate the speed and climb of the robot
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            if (!lastPressed.equals("a")){
                chassis.rightSideEncoders.get(0).getAssignedMotor().resetSpeed();
                chassis.leftSideEncoders.get(0).getAssignedMotor().resetSpeed();
            }
            lastPressed = "a";
            chassis.rightSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            chassis.leftSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            x += chassis.leftSideEncoders.get(0).getAssignedMotor().getInvertedSpeed() + chassis.rightSideEncoders.get(0).getAssignedMotor().getInvertedSpeed();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            if (!lastPressed.equals("s")){
                chassis.rightSideEncoders.get(0).getAssignedMotor().resetSpeed();
                chassis.leftSideEncoders.get(0).getAssignedMotor().resetSpeed();
            }
            lastPressed = "s";
            chassis.rightSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            chassis.leftSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            y += chassis.leftSideEncoders.get(0).getAssignedMotor().getInvertedSpeed() + chassis.rightSideEncoders.get(0).getAssignedMotor().getInvertedSpeed();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            if (!lastPressed.equals("dddddddd")){
                chassis.rightSideEncoders.get(0).getAssignedMotor().resetSpeed();
                chassis.leftSideEncoders.get(0).getAssignedMotor().resetSpeed();
            }
            lastPressed = "d";
            chassis.rightSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            chassis.leftSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            x += chassis.leftSideEncoders.get(0).getSpeed() + chassis.rightSideEncoders.get(0).getSpeed();
        }
    }
}
