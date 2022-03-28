package sk.uniza.fri.wof.miestnosti;

import sk.uniza.fri.wof.predmety.OvladacVytahu;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Vytah extends Miestnost {
    private int poschodie;
    private Miestnost[] poschodia;
    private boolean ideHore;

    public Vytah(Miestnost... poschodia) {
        super("Ultra moderny vytah");
        this.poschodia = poschodia;
        this.poschodie = 1;
        this.ideHore = true;
        for (Miestnost miestnost : poschodia) {
            miestnost.pridajVychod("vytah", this);
        }

        this.pridajPredmet(new OvladacVytahu(this));
        this.pridajVychod("von", poschodia[this.poschodie]);
    }

    public void posunVytah() {
        if (this.ideHore) {
            if (this.poschodie < this.poschodia.length - 1) {
                this.poschodie++;
            } else {
                this.poschodie--;
                this.ideHore = false;
            }
        } else {
            if (this.poschodie > 0) {
                this.poschodie--;
            } else {
                this.poschodie++;
                this.ideHore = true;
            }
        }
        System.out.println("Vitaj na poschodi " + (this.poschodie - 1));
        this.pridajVychod("von", this.poschodia[this.poschodie]);
    }
}
