package turner.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	private final JLabel label1;
	private final JLabel label2;
	private final JButton button1;
	private final JTextField textField;;

	public JFrameDemo() {
		setTitle("JFrameDemo");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final Container container = getContentPane();
		// layout manager
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS)); // vertical
		// display

		// add text field
		label1 = new JLabel("All this text gets shown all the time");
		add(label1);
		label2 = new JLabel("MORE LABELS");
		add(label2);
		button1 = new JButton("Button1");
		add(button1);
		textField = new JTextField();
		add(textField);

		// button click action
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("Button click works!");
				textField.setText("YAY!");
			}
		});

	}
}
