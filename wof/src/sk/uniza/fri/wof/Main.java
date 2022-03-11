package sk.uniza.fri.wof;

import sk.uniza.fri.wof.hra.Hra;

/**
 * Hlavna trieda hry WoF s metodou main - spustanie v NB
 *
 * @author Lubomir Sadlon
 * @version 21.2.2012
 */
public class Main {

    /*
     * - pocitanie kolko hrac nachodil
     * - pamätanie si cesty ktoru presiel, aby sa dalo ist späť
     * - dvere
     * - itemy
     * - schpnosti
     *
     */


    /**
     * @param args parametre programu
     */
    public static void main(String[] args) {
        Hra hra = new Hra();
        hra.hraj();
    }
}
