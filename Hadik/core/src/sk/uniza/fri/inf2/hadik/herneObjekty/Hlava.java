package sk.uniza.fri.inf2.hadik.herneObjekty;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hlava extends HernyObjekt {

    public Hlava(int x, int y) {
        super(new Texture("hlava.png"), x, y);
    }

    public void posun(Smer smer) {
        this.setX((this.getX() + smer.getPosunX() + 20) % 20);
        this.setY((this.getY() + smer.getPosunY() + 15) % 15);
    }
}
