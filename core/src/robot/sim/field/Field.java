package robot.sim.field;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import robot.sim.hardware.Robot;
import java.awt.*;

public class Field {

    //graphics
    private Texture texture;
    float width,height;
    SpriteBatch batch;

    //boundingboxes
    private Rectangle scoreboard0, scoreboard1;

    //field robot
    robot.sim.hardware.Robot robot;
    
    public Field(Robot robot){
        this.robot = robot;
        texture = new Texture("infinite-recharge.jpg");
        batch = new SpriteBatch();
    }

    public float getWidth(){
        return 1280;
    }

    public float getHeight(){
        return 720;
    }

    public void render(float delta){
        batch.begin();
        batch.draw(texture,0,0,1280,720);//draws field
        robot.updateBot(delta);
        robot.shooter.getProjectile().display(batch);
        batch.draw(robot.getTexture(),robot.getX(),robot.getY(),robot.getWidth(),robot.getLength());//draws robot
        //robot.shooter.projectile.display(batch);
        //if (robot.getAuto()){
            //robot.startAutonomousPeriodic(delta);
        //}
        batch.end();
    }
}
