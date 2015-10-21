package turner.projectile;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectileGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	private final JLabel label4;
	private final JTextField textField1;
	private final JTextField textField2;
	private final JTextField textField3;
	private final JTextField textField4;
	private final JButton button;

	public ProjectileGUI() {

		setTitle("ProjectileGUI");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final Container container = getContentPane();

		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		label1 = new JLabel("Angle");
		add(label1);
		textField1 = new JTextField();
		add(textField1);
		label2 = new JLabel("Velocity");
		add(label2);
		textField2 = new JTextField();
		add(textField2);
		label3 = new JLabel("Time");
		add(label3);
		textField3 = new JTextField();
		add(textField3);
		button = new JButton("Compute");
		add(button);
		label4 = new JLabel("Result");
		add(label4);
		textField4 = new JTextField();
		add(textField4);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				double angle = Double.parseDouble(textField1.getText());
				double velocity = Double.parseDouble(textField2.getText());
				double time = Double.parseDouble(textField3.getText());
				double x = Math.sin(Math.toRadians(angle)) * velocity * time;
				double y = Math.cos(Math.toRadians(angle)) * velocity * time
						- (.5 * 9.8 * time * time);
				textField4.setText("(" + x + ", " + y + ")");

			}
		});

	}
}
