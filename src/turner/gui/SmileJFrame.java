package turner.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SmileJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public SmileJFrame() {
		setTitle("Smile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final BorderLayout layout = new BorderLayout();
		final Container container = getContentPane();
		container.setLayout(layout);
		container.add(new SmileComponent(), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new SmileJFrame().setVisible(true);

	}
}
