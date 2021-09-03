package robot.sim.hardware;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Projectile {

    float x, y, width, height, speed;//dimensions and position
    Texture texture;
    Rectangle hitbox;
    SpriteBatch batch = new SpriteBatch();
    boolean outOfField;

    public float getX(){return x;}
    public float getY(){return y;}
    public float getWidth(){return width;}
    public float getHeight(){return height;}
    public float getSpeed(){return speed;}
    public Rectangle getHitbox(){return hitbox;}

    public Projectile(float x, float y, float width, float height){
        texture = new Texture("pixil-frame-0.png");
        hitbox = new Rectangle();
        this.width = width;
        this.height = height;
        hitbox.height = height;
        hitbox.width = width;
    }

    public void display(){
        hitbox.x = x;
        hitbox.y = y;
        batch.begin();
        batch.draw(texture, x, y, width, height);
        batch.end();
    }

    public void setPos(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void validatePos(){
        if(getX() < 0){
            outOfField = true;
        }else if(getX() > 1179) {
            outOfField = true;
        }

        if (getY() > 619){
            outOfField = true;
        }else if(getY() < .7){
            outOfField = true;
        }
    }

    public void moveX(float xchange){
        x += xchange;
    }

    public void moveY(float ychange){
        y += ychange;
    }
}
