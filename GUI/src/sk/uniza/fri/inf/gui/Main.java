package sk.uniza.fri.inf.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Michal
 * Date: 3. 5. 2022
 * Time: 10:01
 */
public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Moje prve okno");
        jFrame.setMinimumSize(new Dimension(600, 400));
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int volba = JOptionPane.showConfirmDialog(jFrame,
                        "Skutočne chceš zatvoriť aplikaciu",
                        "Potvrdenie",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (volba == JOptionPane.YES_OPTION) {
                    jFrame.dispose();
                }
            }
        });
        //jFrame.setUndecorated(true);

        jFrame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Zadaj meno");
        topPanel.add(label, BorderLayout.WEST);

        JTextField jTextField = new JTextField();
        topPanel.add(jTextField, BorderLayout.CENTER);

        JButton pozdravButton = new JButton("Pozdrav");
        topPanel.add(pozdravButton, BorderLayout.EAST);

        jFrame.add(topPanel, BorderLayout.NORTH);

        JPanel jPanelTlacidlo = new JPanel();
        jPanelTlacidlo.setLayout(null);
        jPanelTlacidlo.setBackground(Color.GREEN);
        //jFrame.add(jPanelTlacidlo, BorderLayout.CENTER);
        jFrame.add(new MojKomponent());

        JButton jButtonZatvor = new JButton("Zatvor okno");
        jButtonZatvor.addActionListener(e -> jFrame.dispose());
        jButtonZatvor.setBounds(100, 100, 110, 20);
        Random random = new Random();
        jButtonZatvor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jButtonZatvor.setBounds(
                        random.nextInt(jPanelTlacidlo.getWidth() - 110),
                        random.nextInt(jPanelTlacidlo.getHeight() - 20),
                        110,
                        20);
            }
        });


        jPanelTlacidlo.add(jButtonZatvor);

        jFrame.setVisible(true);
    }
}
