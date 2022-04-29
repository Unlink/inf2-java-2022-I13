package sk.uniza.fri.inf.zoo;

import java.util.Iterator;

/**
 * 29. 4. 2022 - 10:26
 *
 * @author Michal
 */
public class FibonacciIterator implements Iterator<Integer> {
    private int pocetCisel;
    private int c1;
    private int c2;

    public FibonacciIterator(int pocetCisel) {
        this.pocetCisel = pocetCisel;
        this.c1 = 1;
        this.c2 = 0;
    }

    @Override
    public boolean hasNext() {
        return pocetCisel > 0;
    }

    @Override
    public Integer next() {
        this.pocetCisel--;
        int stare = this.c2;
        int nove = this.c1 + this.c2;
        this.c2 = this.c1;
        this.c1 = nove;

        return stare;
    }
}
