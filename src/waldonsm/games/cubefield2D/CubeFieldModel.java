/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package waldonsm.games.cubefield2D;

import java.awt.Point;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author shawn
 */
public class CubeFieldModel {

    public static final int NOMOVE = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = -1;
    public static final int MY_Y = 400;
    public final Triangle ME = getTriangle();
    public static final int MY_X = 240;

    private CubeFieldView gameView;
    private LinkedList<Cube> cubes;
    private int direction;
    private long lastAdd;
    private int diffFactor;
    private int speed;
    private int score;
    private boolean dead;

    public CubeFieldModel() {
        direction = 0;
        cubes = new LinkedList<Cube>();
        lastAdd = System.nanoTime();
        diffFactor = 1;
        speed = 2;
        score = 0;
        dead = false;
    }
    
    public void die() {
    	dead = true;
    }
    
    public boolean isDead() {
    	return dead;
    }

    public void setGameView(CubeFieldView view) {
        gameView = view;
    }

    public void setDirection(int dir) {
        direction = dir;
    }

    public int getDirection() {
        return direction;
    }

    public void move(int dx) {
        if (System.nanoTime() - lastAdd > 100000000 / diffFactor) {
                cubes.add(0,new Cube());
            lastAdd = System.nanoTime();
        }
        ListIterator<Cube> itr = cubes.listIterator(0);
        while(itr.hasNext()) {
            Cube c = itr.next();
            c.move(-dx, speed);
            if (c.getY() > 475)
                itr.remove();
        }
//        ArrayList<Cube> oldCubes = new ArrayList<Cube>();
//        for (Cube c : cubes) {
//            c.move(-dx, speed);
//            if (c.getY() > 475)
//                oldCubes.add(c);
//        }
//        for (Cube c : oldCubes) {
//            cubes.remove(c);
//        }
        gameView.somethingChanged();
    }

    public boolean collided() {
        for (Cube c: cubes) {
            if (c.getY() < 370 || c.getY() > 420) {
                //do nothing
            } else {
                for (int i = 0; i < 3; i++) {
                    Point p = ME.getPoint(i);
                    if (p.x > c.getX() && p.x < c.getX() + CubeFieldPanel.CUBE_WIDTH) {
                        if (p.y > c.getY() && p.y < c.getY() + CubeFieldPanel.CUBE_HEIGHT) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static Triangle getTriangle() {
        int[] xs = {MY_X, MY_X + 10, MY_X-10};
        int[] ys = {MY_Y, MY_Y + 20, MY_Y + 20};
        return new Triangle(xs,ys);
    }

    public LinkedList<Cube> getCubes() {
        return cubes;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int amount) {
        score += amount;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDiffFactor() {
        return diffFactor;
    }

    public void setDiffFactor(int factor) {
        diffFactor = factor;
    }
}
