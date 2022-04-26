package sk.uniza.fri.wof.nacitavacMapy;

import sk.uniza.fri.wof.miestnosti.IMapa;
import sk.uniza.fri.wof.miestnosti.Miestnost;
import sk.uniza.fri.wof.predmety.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class ExternaMapa implements IMapa  {
    private HashMap<String, Miestnost> mietnosti;
    private HashMap<String, ITovarenNaPredmety> tovarnicky;
    private Miestnost startovaciaMiestnost;

    public ExternaMapa() throws IOException {
        this.mietnosti = new HashMap<>();
        this.tovarnicky = new HashMap<>();
        this.tovarnicky.put("Hodinky", (nazov, parametre) -> new Hodinky());
        this.tovarnicky.put("Jedlo", (nazov, parametre) -> new Jedlo(nazov, Integer.parseInt(parametre)));
        this.nacitajMapu();
    }

    private void nacitajMapu() throws IOException {
        ArrayList<Riadok> riadky = NacitavacSuboru.nacitajSubor(new File("mapa.yml"));

        nacitajMiestnosti(riadky);
        nacitajObsahMiestnosti(riadky);

        Riadok riadok = riadky.get(riadky.size() - 1);
        this.startovaciaMiestnost = this.mietnosti.get(riadok.getHodnota());
    }

    private void nacitajObsahMiestnosti(ArrayList<Riadok> riadky) {
        String miestnost = null;
        String miestnostParameter = null;
        for (Riadok riadok : riadky) {
            if (riadok.getOdsadenie() == 2) {
                miestnost = riadok.getKluc();
            }
            if (riadok.getOdsadenie() == 4) {
                miestnostParameter = riadok.getKluc();
            }

            if (riadok.getOdsadenie() == 6) {
                Miestnost m = this.mietnosti.get(miestnost);
                switch (miestnostParameter) {
                    case "vychody":
                        m.pridajVychod(riadok.getKluc(), this.mietnosti.get(riadok.getHodnota()));
                        break;
                    case "predmety":
                        if (riadok.getHodnota() == null) {
                            m.pridajPredmet(new ZakladnyPredmet(riadok.getKluc()));
                        } else {
                            String[] hodnota = riadok.getHodnota().split(" ", 2);
                            IPredmet predmet = this.tovarnicky.get(hodnota[0])
                                    .vyrobPredmet(riadok.getKluc(), hodnota.length > 1 ? hodnota[1] : null);
                            m.pridajPredmet(predmet);
                        }
                        break;
                }
            }
        }
    }

    private void nacitajMiestnosti(ArrayList<Riadok> riadky) {
        String nazov = null;
        String popis = null;
        for (Riadok riadok : riadky) {
            if (riadok.getOdsadenie() == 2) {
                if (nazov != null) {
                    this.mietnosti.put(nazov, new Miestnost(popis));
                }
                nazov = riadok.getKluc();
                popis = nazov;
            }
            if (riadok.getOdsadenie() == 4 && riadok.getKluc().equals("popis")) {
                popis = riadok.getHodnota();
            }
        }
        this.mietnosti.put(nazov, new Miestnost(popis));
    }

    @Override
    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
