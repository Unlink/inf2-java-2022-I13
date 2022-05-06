package sk.uniza.fri.inf.gui;

import javax.swing.*;
import java.awt.*;

/**
 * 3. 5. 2022 - 10:01
 *
 * @author Michal
 */
public class MojKomponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10));
        g2d.drawLine(100, 100, 250, 400);

        g2d.fillRect(50, 50, 100, 20);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(50, 50, 100, 20);

        g2d.drawString("Ahoj swing", 150, 100);
    }
}
