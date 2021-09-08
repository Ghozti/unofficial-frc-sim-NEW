package robot.sim.field;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import robot.sim.hardware.Robot;
import java.awt.*;

public class Field {

    //graphics
    public final float WIDTH = 1280, HEIGHT = 720;
    private Texture texture;
    float score;
    SpriteBatch batch;
    boolean scoreIncrement;

    //boundingboxes
    public com.badlogic.gdx.math.Rectangle scoreboard0, scoreboard1;

    //field robot
    robot.sim.hardware.Robot robot;
    
    public Field(Robot robot){
        this.robot = robot;
        texture = new Texture("infinite-recharge.jpg");
        batch = new SpriteBatch();

        scoreboard0 = new com.badlogic.gdx.math.Rectangle();
        scoreboard0.y = 459;
        scoreboard0.x = 10;
        scoreboard0.width = 15;
        scoreboard0.height = (int)robot.getLength();

        scoreboard1 = new com.badlogic.gdx.math.Rectangle();
        scoreboard1.y = 150;
        scoreboard1.x = 1260;
        scoreboard1.width = 15;
        scoreboard1.height = (int)robot.getLength();

        score = 0;
    }

    public float getWidth(){
        return 1280;
    }

    public float getHeight(){
        return 720;
    }

    public void updateScore(){
        if (robot.shooter.getProjectile().detectCollision(scoreboard0,scoreboard1) && !scoreIncrement){
            score++;
            scoreIncrement = true;
        }
    }

    public void render(float delta){
        System.out.println(score);
        batch.begin();
        batch.draw(texture,0,0,1280,720);//draws field
        robot.updateBot(delta);
        updateScore();
        scoreIncrement = robot.shooter.getProjectile().getOutOffield();
        robot.shooter.getProjectile().display(batch);
        batch.draw(robot.getTexture(),robot.getX(),robot.getY(),robot.getWidth(),robot.getLength());//draws robot
        //robot.shooter.projectile.display(batch);
        //if (robot.getAuto()){
            //robot.startAutonomousPeriodic(delta);
        //}
        batch.end();
    }
}
