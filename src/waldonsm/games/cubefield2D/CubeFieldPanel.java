/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package waldonsm.games.cubefield2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author shawn
 */
@SuppressWarnings("serial")
public class CubeFieldPanel extends JPanel {

    public static final int CUBE_WIDTH = 20;
    public static final int CUBE_HEIGHT = 20;

    private CubeFieldModel gameModel;
    private JLabel display;

    public CubeFieldPanel(CubeFieldModel model) {
        super();
        gameModel = model;
        display = new JLabel("Score: 0");
        add(display);
    }

    public void setScore() {
        display.setText("Score: " + gameModel.getScore());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fillPolygon(gameModel.ME);
        g2.setColor(Color.red);
        for (Cube c: gameModel.getCubes()) {
            g2.fillRect(c.getX(), c.getY(), CUBE_WIDTH, CUBE_HEIGHT);
        }
    }

    public void setGameModel(CubeFieldModel cfm) {
        gameModel = cfm;
    }
}
