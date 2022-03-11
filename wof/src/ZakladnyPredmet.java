import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class ZakladnyPredmet implements IPredmet {
    private String nazov;

    public ZakladnyPredmet(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouziSa() {
        System.out.println("Pouzil som " + this.nazov);
    }
}
