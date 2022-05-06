package sk.uniza.fri.inf.gui;

/**
 * 6. 5. 2022 - 9:58
 *
 * @author Michal
 */
public record Student(String meno, String priezvisko, int vek) {
    public String getFullName() {
        return this.meno + " " + this.priezvisko;
    }
}
