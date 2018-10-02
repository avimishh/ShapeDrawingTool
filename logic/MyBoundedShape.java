package logic;

import java.awt.Color;
import java.awt.Graphics;

/**
 * MyBoundedShape.java abstract class that uses classes MyRectangle and MyOval.
 * extend {@link MyShape}
 */
public abstract class MyBoundedShape extends MyShape {

	private boolean filled;

	/**
	 * Instantiates a new my bounded shape.
	 */
	public MyBoundedShape() {
		filled = false;
	}

	/**
	 * Instantiates a new my bounded shape.
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
	 *            filled
	 */
	public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean filled) {
		super(x1, y1, x2, y2, color);
		this.filled = filled;
	}

	/**
	 * Gets the upper left X.
	 *
	 * @return the upper left X
	 */
	public int getUpperLeftX() {
		return Math.min(getX1(), getX2());
	}

	/**
	 * Gets the upper left Y.
	 *
	 * @return the upper left Y
	 */

	public int getUpperLeftY() {
		return Math.min(getY1(), getY2());
	}

	/**
	 * get shape width
	 *
	 * @return the width
	 */
	public int getWidth() {
		return Math.abs(getX2() - getX1());
	}

	/**
	 * get shape height
	 * 
	 * @return the height
	 */
	public int getHeight() {
		return Math.abs(getY2() - getY1());
	}

	/**
	 * Checks if is filled.
	 *
	 * @return true, if is filled
	 */
	public boolean isFilled() {
		return filled;
	}

	/**
	 * sets whether this shape is filled.
	 *
	 * @param filled
	 *            indicator if the shape filled
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
}
