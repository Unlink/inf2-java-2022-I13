package sk.uniza.fri.wof.miestnosti;

import sk.uniza.fri.wof.predmety.IPredmet;

import java.util.TreeMap;

/**
 * Trieda sk.uniza.fri.wof.miestnosti.Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {
    private final String popisMiestnosti;
    private TreeMap<String, Miestnost> vychody;
    private TreeMap<String, IPredmet> predmety;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String popis) {
        this.popisMiestnosti = popis;
        this.vychody = new TreeMap<>();
        this.predmety = new TreeMap<>();
    }

    public void pridajVychod(String smer, Miestnost miestnost) {
        this.vychody.put(smer, miestnost);
    }

    public void pridajPredmet(IPredmet predmet) {
        this.predmety.put(predmet.getNazov(), predmet);
    }


    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {
        return this.popisMiestnosti;
    }

    public void vypisInfo() {
        System.out.println("Teraz si v miestnosti " + this.getPopis());
        System.out.print("Vychody: ");
        for (String smer : this.vychody.keySet()) {
            System.out.print(smer + " ");
        }
        System.out.println();
    }

    public void vypisPredmety() {
        if (this.predmety.isEmpty()) {
            System.out.println("V miestnosti nic nieje");
            return;
        }
        System.out.print("Predmety: ");
        for (String predmet : this.predmety.keySet()) {
            System.out.print(predmet + " ");
        }
        System.out.println();
    }

    public Miestnost dajMiestnostVSmere(String smer) {
        return this.vychody.get(smer);
    }

    public IPredmet zoberPredmet(String nazov) {
        return this.predmety.remove(nazov);
    }

    public IPredmet najdiPredmet(String nazov) {
        return this.predmety.get(nazov);
    }
}
