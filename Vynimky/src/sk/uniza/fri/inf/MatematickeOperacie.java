package sk.uniza.fri.inf;

import javax.swing.*;
import java.math.BigInteger;

/**
 * @author Stefan
 */
public class MatematickeOperacie {

    // TODO: Uloha 1.1 - opravte chybu (java.lang.StackOverflowError) vo vypocte faktorialu
    // TODO: Uloha 1.3 - pridajte sem dokumentacny komentar a popise o com je tato metoda a ake vynimky vyhadzuje (inspirovat sa mozete napr. triedou Scanner a metodou nextInt())


    /**
     * Vypocita faktorial
     * @param cislo
     * @return faktorial cisla
     * @throws IllegalArgumentException ked je cislo < 0
     */
    public static int faktorial(int cislo) throws IllegalArgumentException {
        if (cislo < 0) {
            throw new IllegalArgumentException("Parameter cislo nemoze byt zaporny, zadane " + cislo);
        }
        if (cislo == 0) {
            return 1;
        }
        return cislo * faktorial(cislo - 1);
    }

    // TODO: Uloha 1.4 - vypiste do konzoly retazec v tomto formate: "cislo! = vysledok"
    public static void vypisFaktorialCisla(int cislo) {
        BigInteger faktorial = BigInteger.ONE;
        for (int i = 1; i <= cislo; i++) {
            faktorial = faktorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(cislo + "! = " + faktorial);
    }

    public static void vypisVysledkyDelitela(int delenec) {
        for (int delitel = 1; delitel < 10; delitel++) {
            System.out.println(delenec + " / " + delitel + " = " + delenec / delitel);
        }
    }

    public static double vypocitaj(double cislo1, String znamienko, double cislo2) {
        return switch (znamienko) {
            case "+" -> cislo1 + cislo2;
            case "-" -> cislo1 - cislo2;
            case "*" -> cislo1 * cislo2;
            case "/" -> cislo1 / cislo2;
            case null -> throw new NullPointerException();
            default -> throw new IllegalArgumentException("Neplatna operacia " + znamienko);
        };
    }

    public enum TypVynimky {
        THROWABLE,
        ERROR,
        EXCEPTION,
        RUNTIME_EXCEPTION,
        RUNTIME_NULL_POINTER_EXCEPTION,
        VLASTNA_KONTROLOVANA_VYNIMKA,
        VLASTNA_NEKONTROLOVANA_VYNIMKA,
    }

    public static void vyhodUmeluVynimku(TypVynimky typVynimky) throws Exception, Throwable {
        switch (typVynimky) {
            case THROWABLE:
                throw new Throwable("Thrrowablwe");
            case ERROR:
                throw new Error("error");
            case EXCEPTION:
                throw new Exception("Testovacia kontrolovana vynimka");
            case RUNTIME_EXCEPTION:
                throw new RuntimeException("Testovacia nekontrolovana runtime vynimka");
            case RUNTIME_NULL_POINTER_EXCEPTION:
                throw new NullPointerException("Testovacia nekontrolovana runtime vynimka");
            case VLASTNA_KONTROLOVANA_VYNIMKA:
                //TODO: Uloha 1.14 - vyhodte vlastnu kontrolovanu vynimku (napr. s nazvom KontrolovanaException)
            case VLASTNA_NEKONTROLOVANA_VYNIMKA:
                //TODO:  Uloha 1.15 - vyhodte vlastnu nekontrolovanu vynimku (napr. s nazvom NekontrolovanaException)
        }
    }

    public static void vyhodVlastnuKontrolovanuVynimku() throws MojaKontrolovanaVynimka {
        throw new MojaKontrolovanaVynimka();
    }

    public static void vyhodVlastnuNekontrolovanuVynimku() {
        //TODO: Uloha 1.17 - vyhodte vlastnu nekontrolovanu vynimku
        throw new UnsupportedOperationException();
    }

}
