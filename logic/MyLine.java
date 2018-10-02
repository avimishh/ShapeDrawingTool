package logic;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class draw Lines. This is a sub-class of the abstract-class MyShape.
 */
public class MyLine extends MyShape {
	/**
	 * Instantiates a new my line.
	 *
	 * @param x1
	 *            the x 1
	 * @param y1
	 *            the y 1
	 * @param x2
	 *            the x 2
	 * @param y2
	 *            the y 2
	 * @param color
	 *            the color
	 */
	public MyLine(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color);
	}

	/**
	 * An implementation of the abstract method.
	 * 
	 * @param g
	 *            Graphics-class object.
	 */
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}
}
