package turner.pi;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PiFrame extends JFrame{

	public PiFrame(){
		setTitle("Pi");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Pi calculation in progress");
		
		Container contentPane = getContentPane();
		contentPane.add(label);
		
		PiCalculationThread thread = new PiCalculationThread(label);
		thread.start(); //tell OS to start thread and call run.
	}
	
	public static void main (String [] args){
		new PiFrame().setVisible(true);
	}
}
