package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import logic.*;

/**
 * DrawPanel is the smart drawing panel. It extends the API
 * {@link javax.swing.JPanel} JPanel, so it has capabilities of JPanel (to draw
 * Shapes, using the {@link java.awt.Graphics} object methods – sent as a
 * parameter to {@link javax.swing.JPanel#paintComponent(Graphics g)} method),
 * but it also implements the entire state-machine for drawing the shapes. In
 * fact, most of the sophistication of this project will be in this class!
 */
public class DrawPanel extends JPanel {
	ArrayList<MyShape> shapes; // array containing all the shapes
	private MyShape currentShape;
	boolean currentShapeFlag; // flags if current shape is active, true when perform mouse actions

	// state variables
	private Color drawingColor;
	private int shapeType;
	private boolean shapeFilled;

	private JLabel statusLabel; // reference to statusLabel from DrawFrame

	int x1Pos = 0, y1Pos = 0; // coordinates for mouseListener

	/**
	 * Setting the {@link java.awt.Color} of the current shape.
	 * 
	 * @param color
	 *            the new drawing color.
	 */
	public void setDrawingColor(Color color) {
		drawingColor = color;
	}

	/**
	 * Sets the shape type.
	 * 
	 * @param shapeType
	 *            the new shape type.
	 */
	public void setShapeType(int shapeType) {
		this.shapeType = shapeType;
	}

	/**
	 * Sets the shape filled.
	 * 
	 * @param shapeFilled
	 *            the new shape filled.
	 */
	public void setShapeFilled(boolean shapeFilled) {
		this.shapeFilled = shapeFilled;
	}

	/**
	 * Instantiates a new draw panel.
	 * 
	 * @param statusLabel
	 *            the status label reference.
	 */
	public DrawPanel(JLabel statusLabel) {
		this.statusLabel = statusLabel;
		setBackground(Color.WHITE);
		drawingColor = Color.BLACK; // default
		shapeType = 0; // default
		shapeFilled = false; // default
		shapes = new ArrayList<MyShape>();
		currentShapeFlag = false;
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseHandler());
	}

	/**
	 * Undo shape, remove latest shape created.
	 */
	public void undoShape() {
		if (shapes.isEmpty())
			return;
		shapes.remove((shapes.size()) - 1);
		repaint();
	}

	/**
	 * Clear shape, clear all the panel from shapes.
	 */
	public void clearShape() {
		shapes.clear();
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (MyShape shape : shapes) // draw shapes saved in the array
			shape.draw(g);
		if (currentShapeFlag) // true from mouse action then draw the current shape
			currentShape.draw(g);
	}

	/**
	 * Creates the shape.
	 * 
	 * @param shapeType
	 *            the shape type
	 * @param color
	 *            the color
	 * @param filled
	 *            the filled
	 * @param coordinates
	 *            the coordinates
	 * @return the my shape
	 */
	private MyShape createShape(int shapeType, Color color, boolean filled, int... coordinates) {
		int x1, y1, x2, y2;

		if (coordinates.length != 4)
			return null;

		x1 = coordinates[0];
		y1 = coordinates[1];
		x2 = coordinates[2];
		y2 = coordinates[3];

		switch (shapeType) {
		case 0: // line
			return new MyLine(x1, y1, x2, y2, color);

		case 1: // oval
			return new MyOval(x1, y1, x2, y2, color, filled);

		case 2: // rectangle
			return new MyRectangle(x1, y1, x2, y2, color, filled);
		}

		return null;
	}

	/**
	 * MouseHandler. In case the mouse is pressed via the left button (checked using
	 * {@link java.awt.event.MouseEvent#getButton()}) a new {@link MyShape} must be
	 * created with the specification given by the parent JFrame.
	 */
	private class MouseHandler implements MouseListener, MouseMotionListener {

		@Override
		public void mousePressed(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) // left mouse button pressed?
			{
				if (shapes.size() == 100) { // no more than 100 shapes
					JOptionPane.showMessageDialog(null, "Cannot exceed the current number of shapes: 100",
							"Capacity Overload", JOptionPane.WARNING_MESSAGE);
					return;
				}
				x1Pos = event.getX(); // save for dragged action use
				y1Pos = event.getY(); // save for dragged action use
				currentShapeFlag = true; // approval to draw current shape in paintComponent
				currentShape = createShape(shapeType, drawingColor, shapeFilled, x1Pos, y1Pos, x1Pos, y1Pos);
				repaint();
			}
		}

		@Override
		public void mouseDragged(MouseEvent event) {
			statusLabel.setText(String.format("(%d,%d)", event.getX(), event.getY())); // update statusLabel
			currentShape = createShape(shapeType, drawingColor, shapeFilled, x1Pos, y1Pos, event.getX(), event.getY());
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			currentShapeFlag = false; // stop draw current shape
			if (event.getButton() == MouseEvent.BUTTON1) // only if left mouse button
			{
				if (!(x1Pos == event.getX() && y1Pos == event.getY())) // discard just pressed actions
					shapes.add(currentShape); // save to array
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent event) {
			statusLabel.setText(String.format("(%d,%d)", event.getX(), event.getY())); // update statusLabel
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

	}

}
