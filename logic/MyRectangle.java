package logic;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The Class MyRectangle.
 */
public class MyRectangle extends MyBoundedShape {
	/**
	 * Instantiates a new my rectangle.
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
	public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean filled) {
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
			g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		else
			g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}
}
