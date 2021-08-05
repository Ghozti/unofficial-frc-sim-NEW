package robot.sim.field;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import robot.sim.hardware.Robot;

import java.awt.*;

public class Field {

    //graphics
    private TextureRegion texture;
    float width,height;
    SpriteBatch batch;

    //boundingboxes
    private Rectangle pole0, pole1,pole2,pole3;

    //field robot
    robot.sim.hardware.Robot robot;
    
    public Field(Robot robot){
        this.robot = robot;
    }

    public void render(){
        batch.draw(robot.getTexture(),robot.getX(),robot.getY(),robot.getWidth(),robot.getLength());//draws robot
        batch.draw(texture,0,0,1920,1080);//draws field
    }
}
