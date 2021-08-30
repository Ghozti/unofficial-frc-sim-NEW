package robot.sim.hardware;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Shooter {

    float width, length, x , y;
    Texture projectile;
    Rectangle hitbox;

    SpriteBatch batch;

    public Shooter(float width, float length, float x, float y, Texture projectile){
        this.width = width;
        this.length = length;
        this.x = x;
        this.y = y;
        this.projectile = projectile;
        hitbox = new Rectangle(x,y,width,length);
        batch = new SpriteBatch();
    }

    public void fire(){

    }

    private void render(){

    }
}
