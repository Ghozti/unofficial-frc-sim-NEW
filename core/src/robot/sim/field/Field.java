package robot.sim.field;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;

public class Field {

    //graphics
    private TextureRegion texture;
    float width,height;

    //boundingboxes
    private Rectangle pole0, pole1,pole2,pole3;

    //field robot
    Robot robot;
    
    
    public Field(Robot robot){
        this.robot = robot;
    }

    public void render(){

    }

}
