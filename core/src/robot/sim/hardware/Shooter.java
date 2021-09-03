package robot.sim.hardware;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Shooter{

    float x, y, width, height;
    Projectile projectile;
    boolean readyToFire, fired;

    public float getX() {return x;}
    public float getY() {return y;}
    public float getWidth() {return width;}
    public float getHeight() {return height;}

    public void setReadyToFire(boolean ready){readyToFire = ready;}

    public Shooter(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    String lockedFace = "";

    public void updateProjectile(String robotFace){
        projectile.display();
        if (!fired) {
            lockedFace = robotFace;
        }
        if (readyToFire && !projectile.outOfField){
            fired = true;
            robotFace = lockedFace;
            switch (robotFace){
                case "N": //^
                    projectile.moveY(1);
                    return;
                case "S": //V
                    projectile.moveY(-20);
                    return;
                case "E": //>
                    projectile.moveX(20);
                    return;
                case "W": //<
                    projectile.moveX(-20);
                    return;
            }
        }
    }


    public void updatePos(float x, float y){
        this.x = x;
        this.y = y;
        if (!readyToFire || projectile.outOfField) {
            projectile.setPos(x+37, y-10);
            projectile.outOfField = false;
            fired = false;
            readyToFire = false;
        }
    }
}
