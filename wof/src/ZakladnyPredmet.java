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
        switch (this.nazov) {
            case "hodinky":
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime myObj = LocalTime.now();
                System.out.println(myObj.format(myFormatObj));
                break;
            default:
                System.out.println("Pouzil som " + this.nazov);
        }
    }
}
