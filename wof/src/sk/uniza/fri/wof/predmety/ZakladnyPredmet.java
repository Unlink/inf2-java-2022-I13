package sk.uniza.fri.wof.predmety;

import sk.uniza.fri.wof.predmety.IPredmet;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class ZakladnyPredmet implements IZobratelny {
    private String nazov;

    public ZakladnyPredmet(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouziSa() {
        System.out.println("Pouzil som " + this.nazov);
    }

    @Override
    public boolean mozemZobrat() {
        return true;
    }
}
