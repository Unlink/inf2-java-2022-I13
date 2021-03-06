package sk.uniza.fri.wof;

import org.yaml.snakeyaml.Yaml;
import sk.uniza.fri.wof.hra.Hra;
import sk.uniza.fri.wof.nacitavacMapy.NacitavacSuboru;
import sk.uniza.fri.wof.nacitavacMapy.Riadok;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

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
        Yaml yaml = new Yaml();
        Map<String, Object> obj = yaml.load(new FileInputStream("mapa.yml"));
        System.out.println(obj);


        Hra hra = new Hra();
        hra.hraj();
    }
}
