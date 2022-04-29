package sk.uniza.fri.inf.zoo;
/**
 * Created by IntelliJ IDEA.
 * User: Michal
 * Date: 29. 4. 2022
 * Time: 10:26
 */
public class Main {

    public static void main(String[] args) {
        Klietka<IZviera> klietka = new Klietka<>();
        klietka.pridaj(new Macka());
        klietka.pridaj(new Papagaj());
        Papagaj piratskyPapagaj = new Papagaj();
        piratskyPapagaj.naucFrazu("Som piratsky papagaj");
        klietka.pridaj(piratskyPapagaj);

        naplnKlietku(klietka);
        klietka.zatras();


        FibonacciIterator itr = new FibonacciIterator(10);
        while (itr.hasNext()) {
            int cislo = itr.next();
            System.out.println(cislo);
        }

        for (Integer cislo : new FibonaccihoPostupnost(10)) {
            System.out.println(cislo);
        }

        System.out.println(Excel.IF(5 < 4, "A", "B"));


        System.out.println(Excel.<Integer>MAX(1, 5, 2));
        System.out.println(Excel.MAX(1, 5, 2));
        //System.out.println(Excel.MAX("aaa", "aab", "ccc"));
    }

    private static void naplnKlietku(Klietka<IZviera> klietka) {
        klietka.pridaj(new Macka());
        klietka.pridaj(new Papagaj());
    }
}
