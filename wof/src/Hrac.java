import java.util.TreeMap;

public class Hrac {
    private Miestnost aktualnaMiestnost;
    private TreeMap<String, Predmet> inventar;
    private String meno;
    private int vydrz;

    public Hrac(Miestnost aktualnaMiestnost, String meno) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.meno = meno;
        this.vydrz = 100;
        this.inventar = new TreeMap<>();
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public void prehladajMiestnost() {
        this.aktualnaMiestnost.vypisPredmety();
    }

    /**
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     */
    public void chodDoMiestnosti(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String smer = prikaz.getParameter();

        // Pokus o opustenie aktualnej miestnosti danym vychodom.
        Miestnost novaMiestnost = aktualnaMiestnost.dajMiestnostVSmere(smer);

        if (novaMiestnost == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.aktualnaMiestnost = novaMiestnost;
            this.aktualnaMiestnost.vypisInfo();
        }
    }
}
