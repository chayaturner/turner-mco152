package turner.connect4;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Connect4Board {

	private JButton[] slots;
	private JButton[] arrows;
	private ImageIcon emptySlot = new ImageIcon("emptySlot.png");
	private ImageIcon yellowPiece = new ImageIcon("yellowPiece.jpg");
	private ImageIcon redPiece = new ImageIcon("redPiece.jpg");
	// private ImageIcon dropArrow = new ImageIcon("dropArrow.png");
	private int[] board;
	private int turn = 1;
	private int tieCount = 0;
	private boolean gameOver = false;

	public Connect4Board(int[] board, JButton[] slots, JButton[] arrows) {
		this.board = board;
		this.slots = slots;
		this.arrows = arrows;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void dropPiece(ActionEvent e) {
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

	public void gameOverMessage() {
		if (gameOver) {
			int message = JOptionPane.showConfirmDialog(null, "Play Again?", "Game Over", JOptionPane.YES_NO_OPTION);
			if (message == 0) {
				restartGame();
			} else {
				System.exit(0);
			}
		}
	}

	public void restartGame() {
		for (int i = 0; i < 42; i++) {
			slots[i].setIcon(emptySlot);
			board[i] = 0;
			turn = 1;
			tieCount = 0;
			gameOver = false;
		}
	}

	public void checkWin() {

		// horizontal
		for (int i = 0; i < 39; i++) {
			if (i % 7 < 5) {
				if (board[i] != 0 && board[i] == board[i + 1] && board[i] == board[i + 2] && board[i] == board[i + 3]) {
					gameOver = true;
				}
			}
		}

		// vertical
		for (int i = 0; i < 22; i++) {
			if (board[i] != 0 && board[i] == board[i + 7] && board[i] == board[i + 14] && board[i] == board[i + 21]) {
				gameOver = true;
			}
		}

		// diagonal
		for (int i = 0; i < 18; i++) {
			if (i % 7 < 4) {
				if (board[i] != 0 && board[i] == board[i + 8] && board[i] == board[i + 16] && board[i] == board[i + 24]) {
					gameOver = true;
				}
			}
		}

		// diagonal
		for (int i = 0; i < 24; i++) {
			if (i % 7 > 2) {
				if (board[i] != 0 && board[i] == board[i + 6] && board[i] == board[i + 12] && board[i] == board[i + 18]) {
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