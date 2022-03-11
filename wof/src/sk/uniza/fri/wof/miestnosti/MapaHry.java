package sk.uniza.fri.wof.miestnosti;

import sk.uniza.fri.wof.predmety.ZakladnyPredmet;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class MapaHry {

    private Miestnost startovaciaMiestnost;


    public MapaHry() {
        this.vytvorMiestnosti();
    }

    /**
     * Vytvori mapu hry - miestnosti.
     */
    private void vytvorMiestnosti() {
        // vytvorenie miestnosti
        Miestnost terasa = new Miestnost("terasa - hlavny vstup na fakultu");
        Miestnost aula = new Miestnost("aula");
        Miestnost bufet = new Miestnost("bufet");
        Miestnost labak = new Miestnost("pocitacove laboratorium");
        Miestnost kancelaria = new Miestnost("kancelaria spravcu pocitacoveho laboratoria");

        // inicializacia miestnosti = nastavenie vychodov
        terasa.pridajVychod("aula", aula);
        terasa.pridajVychod("bufet", bufet);
        terasa.pridajVychod("labak", labak);

        aula.pridajVychod("terasa", terasa);

        bufet.pridajVychod("terasa", terasa);

        labak.pridajVychod("kancelaria", kancelaria);
        labak.pridajVychod("terasa", terasa);

        kancelaria.pridajVychod("labak", labak);

        terasa.pridajPredmet(new ZakladnyPredmet("mineralka"));
        terasa.pridajPredmet(new ZakladnyPredmet("kamen"));

        this.startovaciaMiestnost = terasa;  // startovacia miestnost hry
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }

}
