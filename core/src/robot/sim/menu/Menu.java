package robot.sim.menu;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Menu implements Screen {

    //FIELDS
    boolean exitScreen;//will determine if the player is ready to exit the main menu
    String alliance;
    float[] position;//once the player chooses their alliance position this will be filled in
    float time;//time in miliseconds
    boolean unlimitedTime;
    String periodicType;//autonomous or teleop

    //graphics
    Texture background;


    @Override
    public void show(){

    }
    

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
