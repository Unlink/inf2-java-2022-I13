package sk.uniza.fri.trex;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.LinkedList;
import java.util.Random;

public class MyTrexObrazovka extends ScreenAdapter {
    public static final int SIRKA_PLOCHY = 800;
    public static final int VYSKA_PLOCHY = 600;


    private final MyTrexGame myTrexGame;
    private final SpriteBatch batch;
    private final ShapeRenderer shapeRenderer;
    private final Sprite dyno;
    private final Animation<Sprite> dynoAnimation;
    private final Animation<Sprite> dynoAnimation2;
    private final Animation<Sprite> dynoAnimation3;

    private Camera kamera;
    private Viewport viewport;

    private final Texture img;
    private double yPos = 10;
    private boolean inJump = false;
    private boolean rising = true;
    private final int jumpHeight = 150;
    private float dynoAnimationTime = 0;
    private boolean isDucking = false;

    private final LinkedList<Prekazka> prekazky = new LinkedList<Prekazka>();
    private final Random rnd = new Random();
    private BitmapFont font;

    public MyTrexObrazovka(MyTrexGame myTrexGame) {
        this.myTrexGame = myTrexGame;
        this.batch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();
        this.img = new Texture("offline-sprite-2x.png");
        this.font = new BitmapFont();

        this.dynoAnimation = new Animation<Sprite>(0.25f, new Sprite[] {
                new Sprite(this.img, 1338+88*2, 2, 88, 94),
                new Sprite(this.img, 1338+88*3, 2, 88, 94),
                //new Sprite(this.img, 1338+88*6, 36, 118, 60),
                //new Sprite(this.img, 1338+88*6+118, 36, 118, 60),
        });
        this.dynoAnimation2 = new Animation<Sprite>(0.25f, new Sprite[] {
                new Sprite(this.img, 1338, 2, 88, 94),
                new Sprite(this.img, 1338+88, 2, 88, 94),
        });
        this.dynoAnimation3 = new Animation<Sprite>(0.1f, new Sprite[] {
                new Sprite(this.img, 1338+88*6, 36, 118, 60),
                new Sprite(this.img, 1338+88*6+118, 36, 118, 60),
        });
        this.dynoAnimation.setPlayMode(Animation.PlayMode.LOOP);
        this.dynoAnimation2.setPlayMode(Animation.PlayMode.LOOP);
        this.dynoAnimation3.setPlayMode(Animation.PlayMode.LOOP);

        this.dynoAnimation.getKeyFrames()[0].setRotation(-10);
        //this.dynoAnimation.getKeyFrames()[0].scale(0.1f);

        this.dyno = new Sprite(this.img, 1338+88*2, 2, 88, 94);

        this.kamera = new OrthographicCamera();
        this.viewport = new FitViewport(SIRKA_PLOCHY, VYSKA_PLOCHY, this.kamera);
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.RED);

        //Input spracovanie
        if (!this.inJump && Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            this.inJump = true;
            this.rising = true;
            this.yPos = 10;
        }

        if (!this.inJump && !prekazky.isEmpty() && prekazky.getFirst().x < 170) {
            if (prekazky.getFirst().y > 10) {
                isDucking = true;
            }
            else {
                this.inJump = true;
                this.rising = true;
                this.yPos = 10;
            }
        }
        else {
            isDucking = false;
        }

        if (this.inJump) {
            System.out.println("Jump");
            if (this.rising) {
                this.yPos = (this.yPos + delta * Math.sqrt(2*(this.jumpHeight - this.yPos)) * 40);
                if (this.yPos > this.jumpHeight) {
                    this.rising = false;
                    this.yPos = this.jumpHeight -1;
                }
            }
            else {
                this.yPos = (this.yPos - delta * Math.sqrt(2*(this.jumpHeight - this.yPos)) * 30);
                if (this.yPos < 10) {
                    this.inJump = false;
                    this.yPos = 10;
                }
            }
            System.out.println("pos " + this.yPos);
        }

        //Posun prekazok
        for (Prekazka prekazka : this.prekazky) {
            prekazka.x -= delta * 250;
        }

        //odstranenie starych prekazok
        while (this.prekazky.size() > 0 && this.prekazky.getFirst().x < 0) {
            this.prekazky.removeFirst();
        }

        //Pridanie novych
        if (this.rnd.nextInt() < 10 && (this.prekazky.size() == 0 || this.prekazky.getLast().x < 200)) {
            this.prekazky.add(new Prekazka(Gdx.graphics.getWidth(), this.rnd.nextInt(2) + 1, this.rnd.nextBoolean()));
            if (prekazky.getLast().height == 30 && this.rnd.nextInt(10) < 7) {
                prekazky.getLast().width = 40;
                prekazky.getLast().y = 80;
            }
        }


        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //this.shapeRenderer.setColor(Color.GREEN);
        //this.shapeRenderer.rect(10, (float) this.yPos, 40, 100);

        //Vykrelsenie prekazok
        for (Prekazka prekazka : this.prekazky) {
            this.shapeRenderer.setColor(Color.BLACK);
            this.shapeRenderer.rect(prekazka.x, prekazka.y, prekazka.width, prekazka.height);
        }
        this.shapeRenderer.end();

        this.batch.begin();
        dynoAnimationTime += delta;
        if (inJump) {
            this.batch.draw(dynoAnimation2.getKeyFrame(dynoAnimationTime), 10, (float) yPos);
        } else if (isDucking) {
            //this.batch.setColor(Color.BLACK);
            this.batch.draw(dynoAnimation3.getKeyFrame(dynoAnimationTime), 10, (float) yPos);
        }
        else {
            //this.batch.setColor(Color.BLUE);
            dynoAnimation.getKeyFrame(dynoAnimationTime).setPosition(10, (float) yPos);
            dynoAnimation.getKeyFrame(dynoAnimationTime).draw(this.batch);
        }
        this.font.draw(this.batch, Gdx.graphics.getFramesPerSecond()+"fps", 10, VYSKA_PLOCHY - 20);
        this.batch.end();

    }

    @Override
    public void resize(int width, int height) {
        this.viewport.update(width, height, true);
        this.batch.setProjectionMatrix(this.kamera.combined);
        this.shapeRenderer.setProjectionMatrix(this.kamera.combined);
    }

    @Override
    public void dispose() {
        this.batch.dispose();
        this.img.dispose();
    }


    public class Prekazka {
        int x;
        int y;
        int width;
        int height;

        public Prekazka(int x, int length, boolean big) {
            this.x = x;
            this.y = 10;
            this.width = 30 * length;
            this.height = big ? 60 : 30;
        }


    }
}
