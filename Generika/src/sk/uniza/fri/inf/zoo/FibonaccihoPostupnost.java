package sk.uniza.fri.inf.zoo;

import java.util.Iterator;

/**
 * 29. 4. 2022 - 10:26
 *
 * @author Michal
 */
public class FibonaccihoPostupnost implements Iterable<Integer> {

    private int pocet;

    public FibonaccihoPostupnost(int pocet) {
        this.pocet = pocet;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(pocet);
    }
}
