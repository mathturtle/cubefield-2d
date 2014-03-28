/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package waldonsm.games.cubefield2D;

import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author shawn
 */
@SuppressWarnings("serial")
public class Triangle extends Polygon {

    private int[] xs, ys;

    public Triangle(int[] x, int[] y) {
        super(x,y,3);
        xs = x;
        ys = y;
    }

    public Point getPoint(int i) {
        return new Point(xs[i],ys[i]);
    }
}
