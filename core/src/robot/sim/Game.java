package robot.sim;
public class Game extends com.badlogic.gdx.Game {


	@Override
	public void create() {

	}

	@Override
	public void render() {

	}

	@Override
	public void dispose() {
		super.dispose();
		screen.dispose();
	}

	@Override
	public void resize(int width, int height) {
		screen.resize(width, height);
	}
}
