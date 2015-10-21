package turner.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QuadraticEquationGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private final JLabel labelA;
	private final JTextField textA;
	private final JLabel labelB;
	private final JTextField textB;
	private final JLabel labelC;
	private final JTextField textC;
	private final JLabel x;
	private final JButton button;
	private final JTextField result;

	public QuadraticEquationGUI() {
		setTitle("QuadraticEquationGUI");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		labelA = new JLabel("a");
		add(labelA);
		textA = new JTextField();
		add(textA);
		labelB = new JLabel("b");
		add(labelB);
		textB = new JTextField();
		add(textB);
		labelC = new JLabel("c");
		add(labelC);
		textC = new JTextField();
		add(textC);
		button = new JButton("Compute");
		add(button);
		x = new JLabel("x:");
		add(x);
		result = new JTextField();
		add(result);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				Double a = Double.parseDouble(textA.getText());
				double b = Double.parseDouble(textB.getText());
				double c = Double.parseDouble(textC.getText());
				double posX = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
				double negX = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
				result.setText(posX + ", " + negX);
			}
		});

	}
}
