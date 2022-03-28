package sk.uniza.fri.wof.hra;

import sk.uniza.fri.wof.miestnosti.Miestnost;
import sk.uniza.fri.wof.predmety.Hodinky;
import sk.uniza.fri.wof.predmety.IPredmet;
import sk.uniza.fri.wof.predmety.IZobratelny;
import sk.uniza.fri.wof.predmety.ZakladnyPredmet;
import sk.uniza.fri.wof.prikazy.Prikaz;

import java.util.TreeMap;

public class Hrac {
    private Miestnost aktualnaMiestnost;
    private TreeMap<String, IZobratelny> inventar;
    private String meno;
    private int vydrz;

    public Hrac(Miestnost aktualnaMiestnost, String meno) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.meno = meno;
        this.vydrz = 100;
        this.inventar = new TreeMap<>();
        this.inventar.put("isic", new ZakladnyPredmet("isic"));
        this.inventar.put("hodinky", new Hodinky());
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

    public void zobrazInventar() {
        if (this.inventar.isEmpty()) {
            System.out.println("V inventari nic nieje");
            return;
        }
        System.out.print("Predmety: ");
        for (String predmet : this.inventar.keySet()) {
            System.out.print(predmet + " ");
        }
        System.out.println();
    }

    public void zoberPredmet(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            System.out.println("Zober co?");
            return;
        }

        IPredmet predmet = this.aktualnaMiestnost.zoberPredmet(prikaz.getParameter());
        if (predmet != null) {
            if (predmet instanceof IZobratelny && ((IZobratelny)predmet).mozemZobrat()) {
                this.inventar.put(predmet.getNazov(), (IZobratelny)predmet);
            } else {
                this.aktualnaMiestnost.pridajPredmet(predmet);
                System.out.println("Nekradni");
            }
        } else {
            System.out.println("Tento predmet tu nieje");
        }
    }

    public void polozPredmet(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            System.out.println("Poloz co?");
            return;
        }

        IPredmet predmet = this.inventar.get(prikaz.getParameter());
        if (predmet != null) {
            this.aktualnaMiestnost.pridajPredmet(predmet);
        } else {
            System.out.println("Tento predmet nemam");
        }
    }

    public void pouziPredmet(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            System.out.println("Pouzi co?");
            return;
        }

        IPredmet predmet = this.inventar.get(prikaz.getParameter());
        if (predmet == null) {
            predmet = this.aktualnaMiestnost.najdiPredmet(prikaz.getParameter());
        }

        if (predmet != null) {
            predmet.pouziSa();
        } else {
            System.out.println("Tento predmet nemam");
        }
    }
}
