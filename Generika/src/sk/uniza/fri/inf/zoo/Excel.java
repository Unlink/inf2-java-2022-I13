package sk.uniza.fri.inf.zoo;

/**
 * 29. 4. 2022 - 10:26
 *
 * @author Michal
 */
public class Excel {

    public static <T> T IF(boolean podmienka, T a, T b) {
        return podmienka ? a : b;
    }

    public static <T extends Number & Comparable<T>> T MAX(T... cisla) {
        T max = cisla[0];
        for (T cislo : cisla) {
            if (cislo.compareTo(max) > 0) {
                max = cislo;
            }
        }

        return max;
    }
}
