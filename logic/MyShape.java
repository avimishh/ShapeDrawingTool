package logic;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The Class MyShape.
 */
public abstract class MyShape {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color color;

	/**
	 * Instantiates a new my shape.
	 */

	public MyShape() {
		this(0, 0, 0, 0, Color.BLACK); // call constructor to set values
	}

	/**
	 * Instantiates a new my shape.
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
	public MyShape(int x1, int y1, int x2, int y2, Color color) {
		this.x1 = (x1 >= 0 ? x1 : 0);
		this.y1 = (y1 >= 0 ? y1 : 0);
		this.x2 = (x2 >= 0 ? x2 : 0);
		this.y2 = (y2 >= 0 ? y2 : 0);
		this.color = color;
	}

	/**
	 * set the x-coordinate of the first point.
	 *
	 * @param x1
	 *            the new x1
	 */
	public void setX1(int x1) {
		this.x1 = (x1 >= 0 ? x1 : 0);
	}

	/**
	 * get the x-coordinate of the first point.
	 *
	 * @return the x1
	 */
	public int getX1() {
		return x1;
	}

	/**
	 * set the x-coordinate of the second point.
	 *
	 * @param x2
	 *            the new x2
	 */
	public void setX2(int x2) {
		this.x2 = (x2 >= 0 ? x2 : 0);
	}

	/**
	 * get the x-coordinate of the second point
	 *
	 * @return the x2
	 */
	public int getX2() {
		return x2;
	}

	/**
	 * set the y-coordinate of the first point
	 *
	 * @param y1
	 *            the new y1
	 */
	public void setY1(int y1) {
		this.y1 = (y1 >= 0 ? y1 : 0);
	}

	/**
	 * get the y-coordinate of the first point
	 *
	 * @return the y1
	 */
	public int getY1() {
		return y1;
	}

	/**
	 * set the y-coordinate of the second point
	 *
	 * @param y2
	 *            the new y2
	 */
	public void setY2(int y2) {
		this.y2 = (y2 >= 0 ? y2 : 0);
	}

	/**
	 * get the y-coordinate of the second point
	 *
	 * @return the y2
	 */
	public int getY2() {
		return y2;
	}

	/**
	 * Sets the color.
	 *
	 * @param color
	 *            the new color
	 */

	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */

	public Color getColor() {
		return color;
	}

	/**
	 * Draw.
	 *
	 * @param g
	 *            the g
	 */

	public abstract void draw(Graphics g);
}
