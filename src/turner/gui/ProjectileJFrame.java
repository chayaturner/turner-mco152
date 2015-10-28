package turner.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ProjectileJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public ProjectileJFrame() {
		setTitle("Projectile");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final BorderLayout layout = new BorderLayout();
		final Container container = getContentPane();
		container.setLayout(layout);
		container.add(new ProjectileComponent(), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new ProjectileJFrame().setVisible(true);

	}
}
