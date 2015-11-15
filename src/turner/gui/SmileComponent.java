package turner.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	int y = 250;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.YELLOW);
		g.fillOval(200, 200, 400, 400); // face
		g.setColor(Color.BLUE); // eyes
		g.fillOval(450, 300, 50, 50);
		g.fillOval(300, 300, 50, 50);
		g.setColor(Color.YELLOW);
		g.fillOval(300, y, 50, 50); // blink
		y++;

		if (y == 301) {
			y = 250;
		}

		super.repaint();
		try {
			Thread.sleep(16);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		g.setColor(Color.RED);
		g.drawArc(300, 400, 200, 50, 200, 150); // mouth

	}
}
