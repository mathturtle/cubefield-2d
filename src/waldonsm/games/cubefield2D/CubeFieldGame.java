/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package waldonsm.games.cubefield2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author shawn
 */
public class CubeFieldGame implements ActionListener {

    private CubeFieldView gameView;
    private CubeFieldModel gameModel;
    private KeyResponder keyListener;
    private Timer timer;

    public CubeFieldGame() {
        gameModel = new CubeFieldModel();
        gameView = new CubeFieldView(gameModel, this);
        gameModel.setGameView(gameView);
        keyListener = new KeyResponder(gameModel, this);
        gameView.addKeyListener(keyListener);
        timer = new Timer(10,this);
        JOptionPane.showMessageDialog(null, "Welcome to CubeField\nPress SPACE to start.");
        gameView.requestFocus();
    }

    public void start() {
        timer.start();
    }

    public void pause() {
        if (timer.isRunning())
            timer.stop();
        else
            timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void actionPerformed(ActionEvent e) {
        switch (gameModel.getDirection()) {
            case CubeFieldModel.LEFT:
                gameModel.move(-2);
                break;
            case CubeFieldModel.RIGHT:
                gameModel.move(2);
                break;
            case CubeFieldModel.NOMOVE:
                gameModel.move(0);
                break;
        }
        if (gameModel.collided()) {
            timer.stop();
            gameModel.die();
            HighScoreRecorder.score(gameModel.getScore());
            gameView.requestFocus();
        }
        gameModel.addToScore(1);
        gameView.setScore();
        switch (gameModel.getScore()) {
            case 1000:
                timer.setDelay(9);
                gameModel.setDiffFactor(2);
                break;
            case 5000:
                timer.setDelay(8);
                break;
            case 10000:
                timer.setDelay(7);
                gameModel.setDiffFactor(3);
                break;
            case 25000:
                timer.setDelay(6);
                break;
            case 50000:
                timer.setDelay(5);
                gameModel.setDiffFactor(4);
                break;
            case 100000:
                timer.setDelay(4);
                break;
            case 250000:
                timer.setDelay(3);
                gameModel.setDiffFactor(6);
                break;
            case 500000:
                timer.setDelay(2);
                break;
            case 1000000:
                timer.setDelay(1);
                gameModel.setDiffFactor(8);
                break;
        }
    }

    public void newGame() {
        timer.stop();
        timer.setDelay(10);
        gameModel = new CubeFieldModel();
        gameModel.setGameView(gameView);
        gameView.setGameModel(gameModel);
        keyListener.setGameModel(gameModel);
        gameView.somethingChanged();

    }

    public static void main(String[] args) {
        new CubeFieldGame();
    }
}
