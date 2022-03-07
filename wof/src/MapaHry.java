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
        terasa.nastavVychody(null, aula, labak, bufet);
        aula.nastavVychody(null, null, null, terasa);
        bufet.nastavVychody(null, terasa, null, null);
        labak.nastavVychody(terasa, kancelaria, null, null);
        kancelaria.nastavVychody(null, null, null, labak);

        this.startovaciaMiestnost = terasa;  // startovacia miestnost hry
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }

}
