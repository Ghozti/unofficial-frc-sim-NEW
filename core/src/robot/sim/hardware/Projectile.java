package robot.sim.hardware;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Projectile {

    private float x, y, width, height;//dimensions and position
    private Texture texture;
    private Rectangle hitbox;

    public float getX(){return x;}
    public float getY(){return y;}
    public float getWidth(){return width;}
    public float getHeight(){return height;}
    public Rectangle getHitbox(){return hitbox;}

    public void display(Batch batch){
        batch.begin();
        batch.draw(texture,x,y,width,height);
        batch.end();
    }
}
