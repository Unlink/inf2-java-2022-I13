/**
 * 22. 2. 2022 - 13:23
 *
 * @author Michal
 */
public class Cislo {

    private double cislo;

    public Cislo(double cislo) {
        this.cislo = cislo;
    }

    public Cislo() {
        this.cislo = 0;
    }

    public double getCislo() {
        return this.cislo;
    }

    public void setCislo(double cislo) {
        this.cislo = cislo;
    }

    public String toString() {
        return String.format("%.2f", this.cislo);
    }

    public void vypisNasobilku(int od, int po) {
        for (int i = od; i < po; i++) {
            System.out.printf("%d * %.2f = %.2f\n", i, this.cislo, i * this.cislo);
        }
    }
}
