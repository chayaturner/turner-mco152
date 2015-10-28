package turner.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawOval(200, 200, 400, 400);
		g.setColor(Color.YELLOW);
		g.fillOval(200, 200, 400, 400);
		g.setColor(Color.BLUE);
		g.drawOval(300, 300, 50, 50);
		g.fillOval(300, 300, 50, 50);
		g.drawOval(450, 300, 50, 50);
		g.fillOval(450, 300, 50, 50);
		g.setColor(Color.RED);
		g.drawArc(300, 400, 200, 50, 200, 150);
		g.setColor(Color.RED);

	}
}
