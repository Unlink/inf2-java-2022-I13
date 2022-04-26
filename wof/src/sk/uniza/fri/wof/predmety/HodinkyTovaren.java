package sk.uniza.fri.wof.predmety;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class HodinkyTovaren implements  ITovarenNaPredmety {
    @Override
    public IPredmet vyrobPredmet(String nazov, String parametre) {
        return new Hodinky();
    }
}
