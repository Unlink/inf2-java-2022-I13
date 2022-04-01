package sk.uniza.fri.inf2.hadik;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOverObrazovka extends ScreenAdapter {
    private final HraHadik hra;
    private SpriteBatch batch;
    private BitmapFont font;

    public GameOverObrazovka(HraHadik hra) {
        this.hra = hra;
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0.2f, 0, 1);

        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            hra.setScreen(new HlavnaObrazovka(hra));
        }

        batch.begin();
        font.setColor(Color.RED);
        font.getData().setScale(5);
        font.draw(batch, "Game Over", 50, 300);
        batch.end();
    }
}
