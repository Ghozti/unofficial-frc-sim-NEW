package robot.sim.hardware;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Projectile {

    private float x, y, width, height, speed;//dimensions and position
    private Texture texture;
    private Rectangle hitbox;
    SpriteBatch batch = new SpriteBatch();

    public float getX(){return x;}
    public float getY(){return y;}
    public float getWidth(){return width;}
    public float getHeight(){return height;}
    public float getSpeed(){return speed;}
    public Rectangle getHitbox(){return hitbox;}

    public Projectile(float x, float y, float width, float height){

    }

    public void display(){
        batch.begin();
        batch.draw(texture,x,y,width,height);
        batch.end();
    }

    public void update(String robotFace, float x, float y){

    }

    public void moveX(float xchange){

    }

    public void moveY(float ychange){

    }
}
