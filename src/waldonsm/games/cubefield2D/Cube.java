/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package waldonsm.games.cubefield2D;

import java.util.Random;

/**
 *
 * @author shawn
 */
public class Cube {
    private int x, y;

    private static final Random gen = new Random();

    public Cube() {
        x = gen.nextInt(900) - 200;
        y = -10;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
