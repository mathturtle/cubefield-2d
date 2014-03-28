/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package waldonsm.games.cubefield2D;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author shawn
 */
public class KeyResponder extends KeyAdapter {
    private CubeFieldModel gameModel;
    private CubeFieldGame controller;

    public KeyResponder(CubeFieldModel model, CubeFieldGame contr) {
        gameModel = model;
        controller = contr;
    }

    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                gameModel.setDirection(CubeFieldModel.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                gameModel.setDirection(CubeFieldModel.LEFT);
                break;
            case KeyEvent.VK_N:
                controller.newGame();
                break;
            case KeyEvent.VK_P:
            	if (!gameModel.isDead())
            		controller.pause();
                break;
            case KeyEvent.VK_SPACE:
            	if (!gameModel.isDead())
            		controller.start();
                break;
        }
    }

    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_LEFT)
            gameModel.setDirection(CubeFieldModel.NOMOVE);
    }

    public void setGameModel(CubeFieldModel cfm) {
        gameModel = cfm;
    }
}
