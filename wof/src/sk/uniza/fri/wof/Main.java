package sk.uniza.fri.wof;

import sk.uniza.fri.wof.hra.Hra;
import sk.uniza.fri.wof.nacitavacMapy.NacitavacSuboru;
import sk.uniza.fri.wof.nacitavacMapy.Riadok;

import java.io.File;
import java.io.IOException;

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
    public static void main(String[] args) throws IOException {

        for (Riadok riadok : NacitavacSuboru.nacitajSubor(new File("mapa.yml"))) {
            System.out.println(riadok);
        }

        Hra hra = new Hra();
        hra.hraj();
    }
}
