package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import logic.*;

/**
 * The class {@link DrawFrame} extend {@link JFrame} DrawFrame class constitutes
 * the main window of the application. This class is responsible for creating
 * all the GUI elements and organize these in the introduction section above.
 */
public class DrawFrame extends JFrame implements ActionListener, ItemListener {
	// JComponents
	private final JPanel controlJPanel;
	private final JButton undoButton;
	private final JButton clearButton;
	private final JComboBox<String> colorBox;
	private final JComboBox<String> shapeBox;
	private final JCheckBox filledBox;
	private final JLabel statusLabel;
	// Colors arrays for comboBox
	private static final String[] colorNames = { "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray",
			"Magenta", "Orange", "Pink", "Red", "White", "Yellow" };
	private static Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
			Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };

	// Shape Types for shapeBox
	private static final String[] shapeNames = { "Line", "Oval", "Rectangle" };
	// DrawPanel
	private final DrawPanel drawPanel;

	/**
	 * constructor {@link DrawFrame} class no-argument constructor.
	 */
	public DrawFrame() {
		super("Shape Drawings");
		// Generate components.
		controlJPanel = new JPanel();
		controlJPanel.setLayout(new FlowLayout());
		undoButton = new JButton("Undo");
		clearButton = new JButton("Clear");
		colorBox = new JComboBox<>(colorNames);
		shapeBox = new JComboBox<>(shapeNames);
		filledBox = new JCheckBox("Filled");
		statusLabel = new JLabel();
		drawPanel = new DrawPanel(statusLabel);
		// add components to control panel
		controlJPanel.add(undoButton);
		controlJPanel.add(clearButton);
		controlJPanel.add(colorBox);
		controlJPanel.add(shapeBox);
		controlJPanel.add(filledBox);
		// add panels to frame
		add(controlJPanel, BorderLayout.NORTH);
		add(drawPanel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);

		// Event Listener
		undoButton.addActionListener(this);
		clearButton.addActionListener(this);
		colorBox.addItemListener(this);
		shapeBox.addItemListener(this);
		filledBox.addItemListener(this);
	}

	/**
	 * This method handles the events of the state-saving GUI components: the colors
	 * drop-down list, shapes drop-down list and the check box.
	 * 
	 * @param event
	 *            The ItemEvent that is currently occurring
	 */
	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getSource() == filledBox) {
			drawPanel.setShapeFilled(filledBox.isSelected());
			return;
		}

		if (event.getStateChange() == ItemEvent.SELECTED) {
			if (event.getSource() == colorBox)
				drawPanel.setDrawingColor(colors[colorBox.getSelectedIndex()]);
			else if (event.getSource() == shapeBox)
				drawPanel.setShapeType(shapeBox.getSelectedIndex());
		}
	}

	/**
	 * This method handles the events of the "Undo" and the "Clear" buttons.
	 * 
	 * @param event
	 *            The ActionEvent that is currently occurring
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == clearButton)
			drawPanel.clearShape();
		else if (event.getSource() == undoButton)
			drawPanel.undoShape();
	}

}