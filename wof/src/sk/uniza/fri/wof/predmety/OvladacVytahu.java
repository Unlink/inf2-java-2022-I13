package sk.uniza.fri.wof.predmety;

import sk.uniza.fri.wof.miestnosti.Vytah;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class OvladacVytahu implements IPredmet {
    private final Vytah vytah;

    public OvladacVytahu(Vytah vytah) {
        this.vytah = vytah;
    }

    @Override
    public String getNazov() {
        return "ovladanie";
    }

    @Override
    public void pouziSa() {
        this.vytah.posunVytah();
    }
}
