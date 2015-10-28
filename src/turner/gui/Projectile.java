package turner.gui;

public class Projectile {

	private double angle;
	private double velocity;
	private double time;

	public Projectile(double angle, double velocity, double time) {
		this.angle = Math.toRadians(angle);
		this.velocity = velocity;
		this.time = time;
	}

	public double getX() {
		return Math.sin(angle) * velocity * time;
	}

	public double getY() {
		return Math.cos(angle) * velocity * time - (.5 * 9.8 * (time * time));
	}

	public void setTime(double time) {
		this.time = time;
	}
}
