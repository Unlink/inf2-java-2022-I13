package sk.uniza.fri.inf.gui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Created by IntelliJ IDEA.
 * User: Michal
 * Date: 6. 5. 2022
 * Time: 9:58
 */
public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new HlavneOkno();
    }
}
