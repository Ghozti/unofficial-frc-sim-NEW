package robot.sim.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import robot.sim.field.Field;
import robot.sim.hardware.Chassis;
import robot.sim.hardware.Robot;
import robot.sim.hardware.Shooter;

public class GameLauncher implements Screen {

    Robot robot;
    Field field;

    Batch batch;
    Camera camera;
    Viewport viewport;

    public GameLauncher(){
        robot = new Robot("sol");
        robot.buildChassis(new Chassis("west coast drive"));
        robot.buildShooter(new Shooter(robot.getX(), robot.getY(), 10,10));
        field = new Field(robot);
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new StretchViewport(field.getWidth(),field.getHeight(),camera);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.128f,.128f,.128f,.1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        field.render(delta);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);//tells the viewport to update accordingly
        batch.setProjectionMatrix(camera.combined);
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
