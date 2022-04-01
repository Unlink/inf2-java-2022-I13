package sk.uniza.fri.inf2.hadik.herneObjekty;

public enum Smer {
    HORE(0, 1),
    DOLE(0, -1),
    DOPRAVA(1, 0),
    DOLAVA(-1, 0);

    private final int posunX;
    private final int posunY;

    Smer(int posunX, int posunY) {
        this.posunX = posunX;
        this.posunY = posunY;
    }

    public int getPosunX() {
        return posunX;
    }

    public int getPosunY() {
        return posunY;
    }
}
