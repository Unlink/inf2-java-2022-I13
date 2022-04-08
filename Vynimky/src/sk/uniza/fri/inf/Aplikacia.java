package sk.uniza.fri.inf;

import java.util.Scanner;

/**
 * @author Stefan
 */
public class Aplikacia {

    public static void main(String[] args) {
        // Vysledok by mal byt 6

        int vysledok = MatematickeOperacie.faktorial(3);
        System.out.println(vysledok);

        // Vysledok by mal byt 3628800
        vysledok = MatematickeOperacie.faktorial(10);
        System.out.println(vysledok);

        // TODO: Uloha 1.2 - Osetrite, aby nebolo mozne zadavat zaporne hodnoty (vyhodte v metode faktorial vynimku IllegalArgumentException, tu si to potom samozrejme zakomentujte)
        //vysledok = MatematickeOperacie.faktorial(-10);
        //System.out.println(vysledok);

        // Vysledok by mal byt "5! = 120"
        MatematickeOperacie.vypisFaktorialCisla(5);

        MatematickeOperacie.vypisFaktorialCisla(100);

        //System.out.print("Zadaj cislo: ");
        //Scanner skener = new Scanner(System.in);
        // TODO: Uloha 1.5 - Nacitajte cele cislo pomocou skenera a vypiste jeho faktorial na obrazovku
        // TODO: Uloha 1.6 - Otesujte implementovany kod so zadanymi hodnotami: -10, 123, jeden, 10000

        // TODO: Uloha 1.7 - opravte chybu
        MatematickeOperacie.vypisVysledkyDelitela(100);

        System.out.println(MatematickeOperacie.vypocitaj(1.0, "+", 1.789));
        System.out.println(MatematickeOperacie.vypocitaj(1.0, "-", 1.789));
        System.out.println(MatematickeOperacie.vypocitaj(1.0, "*", 1.789));
        System.out.println(MatematickeOperacie.vypocitaj(1.0, "/", 1.789));
        System.out.println(MatematickeOperacie.vypocitaj(0, "/", 0));
        //System.out.println(MatematickeOperacie.vypocitaj(10, "a", 2));

        try {
            MatematickeOperacie.vyhodUmeluVynimku(MatematickeOperacie.TypVynimky.RUNTIME_EXCEPTION);
        } catch (Error | RuntimeException e) {
            System.out.println("aaa");
        } catch (Throwable e) {
            //e.printStackTrace();
        }

        vysledok = test();
        System.out.println(vysledok);

        try {
            MatematickeOperacie.vyhodVlastnuKontrolovanuVynimku();
        } catch (MojaKontrolovanaVynimka e) {
            e.printStackTrace();
        }
        MatematickeOperacie.vyhodVlastnuNekontrolovanuVynimku();
    }

    private static int test() {
        try {
            //throw new RuntimeException("aaa");
            return MatematickeOperacie.faktorial(-5);
        } catch (IllegalArgumentException exception) {
            return -4;
        } finally {
            //return -2;
            int a = 5;
        }
    }

}
