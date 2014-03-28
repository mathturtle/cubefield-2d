/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package waldonsm.games.cubefield2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author shawn
 */
@SuppressWarnings("serial")
public class CubeFieldView extends JFrame {

    private CubeFieldGame controller;
    private CubeFieldPanel gamePanel;
    private CubeFieldModel gameModel;

    public CubeFieldView(CubeFieldModel model, CubeFieldGame contr) {
        super("CubeField");

        controller = contr;
        gamePanel = new CubeFieldPanel(model);
        gameModel = model;
        add(gamePanel);
        this.setJMenuBar(makeJMenuBar());

        pack();
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JMenuBar makeJMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.newGame();
            }
        });
        file.add(newGame);
        JMenuItem viewScores = new JMenuItem("View High Scores");
        viewScores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.stop();
                HighScoreRecorder.viewHighScores();
            }
        });
        file.add(viewScores);
        JMenuItem close = new JMenuItem("Close");
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(close);
        menuBar.add(file);
        return menuBar;
    }

    public void setScore() {
        gamePanel.setScore();
    }

    public void somethingChanged() {
        repaint();
    }

    public void setGameModel(CubeFieldModel cfm) {
        gameModel = cfm;
        gamePanel.setGameModel(gameModel);
    }
}
