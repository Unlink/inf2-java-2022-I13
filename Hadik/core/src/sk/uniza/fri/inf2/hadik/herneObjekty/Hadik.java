package sk.uniza.fri.inf2.hadik.herneObjekty;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.LinkedList;

public class Hadik {
    private final HerneProstredie herneProstredie;
    private Smer smer;

    private Hlava hlava;
    private LinkedList<Clanok> telo;

    private Texture texturaTela;

    private float pocitadlo;

    public Hadik(HerneProstredie herneProstredie) {
        this.herneProstredie = herneProstredie;
        this.texturaTela = new Texture("clanok.png");
        this.smer = Smer.HORE;
        this.hlava = new Hlava(10, 7);
        this.telo = new LinkedList<>();
        this.telo.add(new Clanok(texturaTela, 10, 6));
        this.telo.add(new Clanok(texturaTela, 10, 5));
        this.telo.add(new Clanok(texturaTela, 9, 5));
        this.pocitadlo = 0;
    }

    public boolean posunSa(float delta) {
        this.spracujOvladanie();
        this.pocitadlo += delta;
        if (this.pocitadlo < 0.5f) {
            return true;
        }
        this.pocitadlo = 0;

        //this.telo.get(this.telo.size()-1).umiestniNa(this.hlava);
        Clanok posledny = this.telo.removeLast();
        posledny.umiestniNa(this.hlava);
        this.telo.addFirst(posledny);

        this.hlava.posun(smer);
        if (herneProstredie.zjecJedlo(this.hlava)) {
            //Pridaj clanok
            this.telo.add(new Clanok(texturaTela, this.telo.getLast().getX(), this.telo.getLast().getY()));
        }

        for (Clanok clanok : telo) {
            if (hlava.koliduje(clanok)) {
                return false;
            }
        }

        return true;
    }

    private void spracujOvladanie() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.smer = Smer.HORE;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.smer = Smer.DOLAVA;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.smer = Smer.DOPRAVA;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.smer = Smer.DOLE;
        }
    }

    public void vykresliSa(SpriteBatch batch) {
        for (Clanok clanok : this.telo) {
            clanok.vykresliSa(batch);
        }
        this.hlava.vykresliSa(batch);
    }
}
