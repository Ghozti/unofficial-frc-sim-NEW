package robot.sim.hardware;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import robot.sim.field.Field;

public class Projectile {

    float x, y, width, height, speed;//dimensions and position
    Texture texture;
    Rectangle hitbox;
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

    public void display(Batch batch){
        hitbox.x = x;
        hitbox.y = y;
        batch.draw(texture, x, y, width, height);
    }

    public void setPos(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void validatePos(){
        if(getX() <= 0){
            outOfField = true;
        }else if(getX() >= 1280) {
            outOfField = true;
        }

        if (getY() >= 720){
            outOfField = true;
        }else if(getY() <= 0){
            outOfField = true;
        }
    }

    public boolean detectCollision(Rectangle hitbox1, Rectangle hitbox2){
        if (hitbox.overlaps(hitbox1) || hitbox.overlaps(hitbox2)){
            outOfField = true;
            return true;
        }
        return false;
    }

    public void moveX(float xchange){
        x += xchange;
        validatePos();
    }

    public void moveY(float ychange){
        y += ychange;
        validatePos();
    }
}
