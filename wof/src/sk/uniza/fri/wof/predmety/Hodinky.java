package sk.uniza.fri.wof.predmety;

import sk.uniza.fri.wof.predmety.IPredmet;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Hodinky implements IPredmet {

    @Override
    public String getNazov() {
        return "hodinky";
    }

    @Override
    public void pouziSa() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime myObj = LocalTime.now();
        System.out.println(myObj.format(myFormatObj));
    }
}
