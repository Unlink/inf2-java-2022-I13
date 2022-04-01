package sk.uniza.fri.inf2.hadik.herneObjekty;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class HernyObjekt {

    private final Texture textura;
    private int x;
    private int y;

    public HernyObjekt(Texture textura, int x, int y) {
        this.textura = textura;
        this.x = x;
        this.y = y;
    }

    public void vykresliSa(SpriteBatch batch) {
        batch.draw(textura, this.x, this.y, 1, 1);
    }

    public int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

    public void umiestniNa(HernyObjekt objekt) {
        this.x = objekt.x;
        this.y = objekt.y;
    }

    public boolean koliduje(HernyObjekt objekt) {
        return this.x == objekt.x && this.y == objekt.y;
    }

    public Texture getTextura() {
        return textura;
    }
}
