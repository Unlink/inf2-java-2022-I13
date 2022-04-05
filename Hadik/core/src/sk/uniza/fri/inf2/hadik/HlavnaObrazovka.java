package sk.uniza.fri.inf2.hadik;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import sk.uniza.fri.inf2.hadik.herneObjekty.Hadik;
import sk.uniza.fri.inf2.hadik.herneObjekty.HerneProstredie;

public class HlavnaObrazovka extends ScreenAdapter {

    private static final int SIRKA_PLOCHY = 20;
    private static final int VYSKA_PLOCHY = 15;
    private final HraHadik hraHadik;

    private Camera kamera;
    private Viewport viewport;

    private SpriteBatch batch;
    private Texture img;

    private Hadik hadik;
    private HerneProstredie herneProstredie;

    public HlavnaObrazovka(HraHadik hraHadik) {
        this.hraHadik = hraHadik;
        this.kamera = new OrthographicCamera();
        this.viewport = new FitViewport(SIRKA_PLOCHY, VYSKA_PLOCHY, this.kamera);

        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        herneProstredie = new HerneProstredie();
        hadik = new Hadik(herneProstredie);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0.2f, 0, 1);

        if (!this.hadik.posunSa(delta)) {
            hraHadik.setScreen(new GameOverObrazovka(hraHadik));
        }

        this.kamera.position.set(hadik.getX(),hadik.getY(), 0);
        this.kamera.update();
        this.batch.setProjectionMatrix(this.kamera.combined);

        batch.begin();
        this.herneProstredie.vykresliSa(batch);
        this.hadik.vykresliSa(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        this.viewport.update(width, height, true);
        this.batch.setProjectionMatrix(this.kamera.combined);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
