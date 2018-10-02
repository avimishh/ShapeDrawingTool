package logic;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The Class MyOval.
 */
public class MyOval extends MyBoundedShape {
	/**
	 * Instantiates a new my oval.
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
	 * @param filled
	 *            the filled
	 */
	public MyOval(int x1, int y1, int x2, int y2, Color color, boolean filled) {
		super(x1, y1, x2, y2, color, filled);
	}

	/**
	 * An implementation of the abstract method.
	 * 
	 * @param g
	 *            Graphics-class object.
	 */

	public void draw(Graphics g) {
		g.setColor(getColor());

		if (isFilled())
			g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}
}
