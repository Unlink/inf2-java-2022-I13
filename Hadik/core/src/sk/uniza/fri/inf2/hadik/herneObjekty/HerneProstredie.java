package sk.uniza.fri.inf2.hadik.herneObjekty;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class HerneProstredie {

    private Potrava potrava;
    private Random generator;

    public HerneProstredie() {
        this.potrava = new Potrava(new Texture("potrava.png"), 2, 2);
        this.generator = new Random();
    }

    public void vykresliSa(SpriteBatch batch) {
        this.potrava.vykresliSa(batch);
    }

    public boolean zjecJedlo(Hlava hlava) {
        if (hlava.koliduje(this.potrava)) {
            this.potrava.setX(this.generator.nextInt(20));
            this.potrava.setY(this.generator.nextInt(15));
            return true;
        }
        return false;
    }
}
