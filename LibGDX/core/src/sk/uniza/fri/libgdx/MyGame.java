package sk.uniza.fri.libgdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private float poziciaX;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(Color.YELLOW);

		//System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
		//System.out.println(Gdx.input.isTouched());

		batch.begin();
		batch.draw(img, Gdx.graphics.getWidth() / 2 - img.getWidth() / 2, Gdx.graphics.getHeight() / 2 - img.getHeight() / 2);
		batch.draw(img, Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), 100, 100);

		batch.draw(img, poziciaX, 20);

		poziciaX+= Gdx.graphics.getDeltaTime() * 300;

		poziciaX = poziciaX % Gdx.graphics.getWidth();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
