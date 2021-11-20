package fi.okko.tictactoe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class TicTacToe extends Game {

	private int[][] gameArray = new int[3][3];

	SpriteBatch batch;
	Texture imgX, imgO, imgBG;

	Camera camera;
	Viewport viewport;

	float worldSize = 3 * 64 + 3 * 5;
	
	@Override
	public void create () {



		camera = new OrthographicCamera();
		viewport = new FitViewport(worldSize, worldSize, camera);
		batch = new SpriteBatch();
		imgBG = new Texture(Gdx.files.internal("images/ticbg.png"));
		imgO = new Texture(Gdx.files.internal("images/tico.png"));
		imgX = new Texture(Gdx.files.internal("images/ticx.png"));

		reset();
	}

	private void reset() {
		for (int i = 0; i < gameArray.length; i++) {
			for (int j = 0; j < gameArray[i].length; j++) {
				gameArray[i][j] = 0;
			}
		}

	}

	@Override
	public void render () {
		viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		batch.setProjectionMatrix(camera.combined);


		Gdx.gl.glClearColor(255, 255, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(imgBG, 0,0);
		batch.end();
	}

	private void drawGrid(SpriteBatch batch) {
		for (int i = 0; i < gameArray.length; i++) {
			for (int j = 0; j < gameArray[i].length; j++) {

				gameArray[i][j] = 0;
			}
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		imgBG.dispose();
		imgO.dispose();
		imgX.dispose();

	}
}
