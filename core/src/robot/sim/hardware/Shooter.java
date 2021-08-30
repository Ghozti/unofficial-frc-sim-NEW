package robot.sim.hardware;

import java.util.ArrayList;

public class Shooter{

    float x, y, width, height;
    Projectile projectile;

    public float getX() {return x;}
    public float getY() {return y;}
    public float getWidth() {return width;}
    public float getHeight() {return height;}

    public Shooter(){
        projectile = new Projectile();
    }

    public void fire(String robotFace){
        projectile.update(robotFace);
        projectile.display();
    }
}
