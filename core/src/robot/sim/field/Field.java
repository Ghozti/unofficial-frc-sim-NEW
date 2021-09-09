package robot.sim.field;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import robot.sim.hardware.Robot;
import robot.sim.hud.HUD;

import java.awt.*;

public class Field {

    //graphics
    public static final float WIDTH = 1280, HEIGHT = 720;
    private Texture texture;
    float score;
    SpriteBatch batch;
    boolean scoreIncrement;
    HUD hud;

    //boundingboxes
    public com.badlogic.gdx.math.Rectangle scoreboard0, scoreboard1;

    //field robot
    robot.sim.hardware.Robot robot;

    //timing
    float elapsed_time;
    
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

        hud = new HUD(70);

        elapsed_time = 0;
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
        elapsed_time += delta;
        batch.begin();
        batch.draw(texture,0,0,1280,720);//draws field
        robot.updateBot(delta);
        updateScore();
        scoreIncrement = robot.shooter.getProjectile().getOutOffield();
        robot.shooter.getProjectile().display(batch);
        batch.draw(robot.getTexture(),robot.getX(),robot.getY(),robot.getWidth(),robot.getLength());//draws robot
        hud.draw(batch,"Score: " + score,10,710,getWidth()/3,false);
        hud.draw(batch,"elapsed time: " + elapsed_time,10,680,getWidth()/3,false);
        batch.end();
    }
}
