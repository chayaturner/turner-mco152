package turner.connect4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Connect4Board {

	private JButton[] slots;
	private JButton[] arrows;
	private ImageIcon emptySlot = new ImageIcon("emptySlot.png");
	private ImageIcon yellowPiece = new ImageIcon("yellowPiece.jpg");
	private ImageIcon redPiece = new ImageIcon("redPiece.jpg");
	private ImageIcon dropArrow = new ImageIcon("dropArrow.png");
	private int[] board;
	private int turn = 1;
	private int tieCount = 0;
	private boolean gameOver = false;

	public void buildBoard(JPanel mainPanel) {

		board = new int[42];
		slots = new JButton[42];
		arrows = new JButton[7];

		// add drop buttons:
		for (int i = 0; i < 7; i++) {
			arrows[i] = new JButton(dropArrow);
			arrows[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dropPiece(e);
					checkWin();

					// next player turn
					if (turn == 1) {
						turn = 2;
					} else {
						turn = 1;
					}

					gameOverMessage();
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

	private void dropPiece(ActionEvent e) {
		int currentColumn = 0;
		int currentPiece = 0;
		ImageIcon currentIcon = redPiece;
		if (turn == 1) {
			currentIcon = yellowPiece;
		}

		// drop at location of click
		Object obj = e.getSource();

		// get column
		for (int i = 0; i < 7; i++) {
			if (obj == arrows[i]) {
				currentColumn = i;
			}
		}
		// get row
		currentPiece = 5 * 7 + currentColumn;
		for (int i = 0; i < 6; i++) {
			if (board[currentPiece] == 0) {
				board[currentPiece] = turn;
				break;
			} else {
				currentPiece -= 7;
			}
		}
		// drop piece if it is valid
		if (!(currentPiece < 0)) {
			slots[currentPiece].setIcon(currentIcon);
			tieCount++;
		}

	}

	private void gameOverMessage() {
		if (gameOver) {
			int message = JOptionPane.showConfirmDialog(null, "Play Again?",
					"Game Over", JOptionPane.YES_NO_OPTION);
			if (message == 0) {
				restartGame();
			} else {
				System.exit(0);
			}
		}
	}

	private void restartGame() {
		for (int i = 0; i < 42; i++) {
			slots[i].setIcon(emptySlot);
			board[i] = 0;
			turn = 1;
			tieCount = 0;
			gameOver = false;
		}
	}

	private void checkWin() {

		// horizontal
		for (int i = 0; i < 39; i++) {
			if (i % 7 < 5) {
				if (board[i] != 0 && board[i] == board[i + 1]
						&& board[i] == board[i + 2] && board[i] == board[i + 3]) {
					gameOver = true;
				}
			}
		}

		// vertical
		for (int i = 0; i < 22; i++) {
			if (board[i] != 0 && board[i] == board[i + 7]
					&& board[i] == board[i + 14] && board[i] == board[i + 21]) {
				gameOver = true;
			}
		}

		// diagonal
		for (int i = 0; i < 18; i++) {
			if (i % 7 < 4) {
				if (board[i] != 0 && board[i] == board[i + 8]
						&& board[i] == board[i + 16]
						&& board[i] == board[i + 24]) {
					gameOver = true;
				}
			}
		}

		// diagonal
		for (int i = 0; i < 24; i++) {
			if (i % 7 > 2) {
				if (board[i] != 0 && board[i] == board[i + 6]
						&& board[i] == board[i + 12]
						&& board[i] == board[i + 18]) {
					gameOver = true;
				}
			}
		}

		// winner message
		if (gameOver) {
			if (turn == 1) {
				JOptionPane.showMessageDialog(null, "Player 1 Wins!");
			} else {
				JOptionPane.showMessageDialog(null, "Player 2 Wins!");
			}
		}

		if (tieCount == 42 && gameOver == false) {
			JOptionPane.showMessageDialog(null, "Tie Game.");
			gameOver = true;
		}

	} // end checkWin
} // end class