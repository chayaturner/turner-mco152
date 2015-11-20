package turner.connect4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Connect4Frame extends JFrame {

	private static final long serialVersionUID = 1L; // default

	private JPanel mainPanel;

	public Connect4Frame() {
		setTitle("Connect Four");
		setVisible(true);
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel(new GridLayout(7, 6));
		buildBoard(mainPanel);
		add(mainPanel);
	}

	public void buildBoard(JPanel mainPanel) {
		int[] board = new int[42];
		JButton[] slots = new JButton[42];
		JButton[] arrows = new JButton[7];

		Connect4Board connect4Board = new Connect4Board(board, slots, arrows);
		ImageIcon dropArrow = new ImageIcon("dropArrow.png");
		ImageIcon emptySlot = new ImageIcon("emptySlot.png");

		// add drop buttons:
		for (int i = 0; i < 7; i++) {
			arrows[i] = new JButton(dropArrow);
			arrows[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					connect4Board.dropPiece(e);
					connect4Board.checkWin();

					// next player turn
					if (connect4Board.getTurn() == 1) {
						connect4Board.setTurn(2);
					} else {
						connect4Board.setTurn(1);
					}

					connect4Board.gameOverMessage();
				} // end actionPerformed

			}); // end actionListener

			mainPanel.add(arrows[i]);

		} // end dropArrows

		// add empty slots:
		for (int i = 0; i < 42; i++) {
			board[i] = 0;
			slots[i] = new JButton(emptySlot);
			mainPanel.add(slots[i]);
		}

	}// end buildBoard()
}
