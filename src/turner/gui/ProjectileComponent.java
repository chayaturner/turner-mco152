package turner.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class ProjectileComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);

		g.drawString("Angle: 31, Velocity: 20", 0, 12);

		g.setColor(Color.BLUE);
		Projectile projectile = new Projectile(31, 20, 0);
		double x = projectile.getX();
		double y = getHeight() - projectile.getY();

		for (double time = 0.0; time < 10; time += 0.01) {
			double prevX = x;
			double prevY = y;
			projectile.setTime(time);
			x = projectile.getX();
			y = getHeight() - projectile.getY();
			((Graphics2D) g).draw(new Line2D.Double(prevX, prevY, x, y));
		}
	}
}
