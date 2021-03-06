package sk.uniza.fri.wof.nacitavacMapy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class NacitavacSuboru {

    public static ArrayList<Riadok> nacitajSubor(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("file je null");
        }
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException(file.getName() + " neexistuje");
        }

        ArrayList<Riadok> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                int kommentStart = line.indexOf("#");
                if (kommentStart > -1) {
                    line = line.substring(0, kommentStart);
                }
                line = line.stripTrailing();
                if (line.isEmpty()) {
                    continue;
                }

                String key = null;
                String value = null;
                boolean pomlcka = false;
                int odsadenie = 0;

                int sep = line.indexOf(":");
                //Kluc: hodnota
                if (sep > -1) {
                    key = line.substring(0, sep).strip();
                    value = line.substring(sep + 1).strip();
                } else {
                    key = line.strip();
                }

                if (key.startsWith("-")) {
                    pomlcka = true;
                    key = key.substring(1).strip();
                }

                for (int i = 0; i < line.length(); i++) {
                    if (Character.isWhitespace(line.charAt(i))) {
                        odsadenie++;
                    } else {
                        break;
                    }
                }


                result.add(new Riadok(key, value, odsadenie, pomlcka));
            }
        }

        return result;
    }

}
