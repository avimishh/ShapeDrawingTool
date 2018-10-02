import ui.*;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * @author Avi Mishayev TestDraw class is simply the class that contains the
 *         main method that creates the DrawFrame object and sets its
 *         properties.
 */
public class Program {
	/**
	 * The main method.
	 * 
	 * @param args
	 *            the args.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}
		DrawFrame draw = new DrawFrame();
		draw.setSize(500, 500);
		draw.setVisible(true);
		draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		draw.setLocationRelativeTo(null);
	}
}
