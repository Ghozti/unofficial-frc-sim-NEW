package robot.sim.hardware;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Shooter{

    float x, y, width, height;
    Projectile projectile;
    boolean readyTofire;

    public float getX() {return x;}
    public float getY() {return y;}
    public float getWidth() {return width;}
    public float getHeight() {return height;}

    public Shooter(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void fire(String robotFace){
        if (readyTofire){
            switch (robotFace){
                case "N": //^
                    return;
                case "S": //V
                    return;
                case "E": //>
                    return;
                case "W": //<
                    return;
            }
        }
    }

    public void updatePos(float x, float y){

    }
}
