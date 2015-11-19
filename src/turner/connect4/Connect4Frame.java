package turner.connect4;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Connect4Frame extends JFrame {

	private static final long serialVersionUID = 1L; // default

	private JPanel mainPanel;
	private Connect4Board board;

	public Connect4Frame() {
		setTitle("Connect Four");
		setVisible(true);
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel(new GridLayout(7, 6));

		board = new Connect4Board();
		board.buildBoard(mainPanel);
		add(mainPanel);
	}
}
