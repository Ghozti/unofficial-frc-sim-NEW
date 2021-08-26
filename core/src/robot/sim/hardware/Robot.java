package robot.sim.hardware;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class Robot {

    float currentSpeed;
    String name;
    Chassis chassis;
    String currentPeriodic;
    boolean auto = true;//wether or not autonomous is still active or not

    //graphicsa
    com.badlogic.gdx.math.Rectangle hitbox = new Rectangle();//hitbox
    Texture texture;
    float x,y;
    float width = 100f, length = 100f;

    public Robot(String name){
        this.name = name;
        hitbox = new Rectangle(getX(),getY(),getWidth(),getLength());
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

    public boolean getAuto(){return auto;}

    public void setY(float y){this.y = y;}

    public void setX(float x){this.x = x;}

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
        //test commit
        //test commit 2
    }

    private String lastPressed = "";
    float ddelta;
    //test

    public void handleInput(float delta){
        ddelta += delta;
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            if (!lastPressed.equals("w")){
                chassis.rightSideEncoders.get(0).getAssignedMotor().resetSpeed();
                chassis.leftSideEncoders.get(0).getAssignedMotor().resetSpeed();
                ddelta = 0;
            }
            lastPressed = "w";
            chassis.rightSideEncoders.get(0).getAssignedMotor().updateSpeed(ddelta);
            chassis.leftSideEncoders.get(0).getAssignedMotor().updateSpeed(ddelta);
            y += chassis.leftSideEncoders.get(0).getSpeed() + chassis.rightSideEncoders.get(0).getSpeed();
        }else if(Gdx.input.isKeyPressed(Input.Keys.A)){
            if (!lastPressed.equals("a")){
                chassis.rightSideEncoders.get(0).getAssignedMotor().resetSpeed();
                chassis.leftSideEncoders.get(0).getAssignedMotor().resetSpeed();
                ddelta = 0;
            }
            lastPressed = "a";
            chassis.rightSideEncoders.get(0).getAssignedMotor().updateSpeed(ddelta);
            chassis.leftSideEncoders.get(0).getAssignedMotor().updateSpeed(ddelta);
            x += chassis.leftSideEncoders.get(0).getAssignedMotor().getInvertedSpeed() + chassis.rightSideEncoders.get(0).getAssignedMotor().getInvertedSpeed();
        }else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            if (!lastPressed.equals("s")){
                chassis.rightSideEncoders.get(0).getAssignedMotor().resetSpeed();
                chassis.leftSideEncoders.get(0).getAssignedMotor().resetSpeed();
                ddelta = 0;
            }
            lastPressed = "s";
            chassis.rightSideEncoders.get(0).getAssignedMotor().updateSpeed(ddelta);
            chassis.leftSideEncoders.get(0).getAssignedMotor().updateSpeed(ddelta);
            y += chassis.leftSideEncoders.get(0).getAssignedMotor().getInvertedSpeed() + chassis.rightSideEncoders.get(0).getAssignedMotor().getInvertedSpeed();
        }else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            if (!lastPressed.equals("d")){
                chassis.rightSideEncoders.get(0).getAssignedMotor().resetSpeed();
                chassis.leftSideEncoders.get(0).getAssignedMotor().resetSpeed();
                ddelta = 0;
            }
            lastPressed = "d";
            chassis.rightSideEncoders.get(0).getAssignedMotor().updateSpeed(ddelta);
            chassis.leftSideEncoders.get(0).getAssignedMotor().updateSpeed(ddelta);
            x += chassis.leftSideEncoders.get(0).getSpeed() + chassis.rightSideEncoders.get(0).getSpeed();
        }
        hitbox.setPosition(getX(),getY());
        validatePosition();
    }

    private void validatePosition(){
        if(getX() <= 0){
            setX(0);
        }else if(getX() >= 1179) {
            setX(1179);
        }

        if (getY() >= 619){
            setY(619);
        }else if(getY() <= .7){
            setY(.7f);
        }
    }

    //AUTONOMOUS

    float t_delta = 0;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////WRITE AUTONOMOUS CODE BELOW VVVVVVV/////////////////////////////////////////
    public void startAutonomousPeriodic(float delta){
        t_delta += delta;
        a_driveBack(1,t_delta);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void a_driveForward(float mil,float delta){
        if (delta < mil){
            chassis.rightSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            chassis.leftSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            x += chassis.leftSideEncoders.get(0).getSpeed() + chassis.rightSideEncoders.get(0).getSpeed();
        }
    }

    public void a_driveBack(float mil,float delta){
        if (delta <= mil){
            chassis.rightSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            chassis.leftSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            x += chassis.leftSideEncoders.get(0).getSpeed() + chassis.rightSideEncoders.get(0).getSpeed();
        }
    }

    public void a_driveUp(float mil,float delta){
        if (delta < mil){
            chassis.rightSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            chassis.leftSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            y += chassis.leftSideEncoders.get(0).getSpeed() + chassis.rightSideEncoders.get(0).getSpeed();
        }
    }

    public void a_driveDown(float mil,float delta){
        if (delta < mil){
            chassis.rightSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            chassis.leftSideEncoders.get(0).getAssignedMotor().updateSpeed(delta);
            y += chassis.leftSideEncoders.get(0).getAssignedMotor().getInvertedSpeed() + chassis.rightSideEncoders.get(0).getAssignedMotor().getInvertedSpeed();
        }
    }
}
