package turner.contacts;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JList;

public class ContactsGui extends JFrame {

	private static final long serialVersionUID = 1L; // default

	// JPanel panel;
	JList<String> list;

	public ContactsGui() {
		setTitle("Contacts");
		setSize(300, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container container = getContentPane();
		setLayout(new BorderLayout());
		// panel = new JPanel(new BorderLayout());
		list = new JList<String>();
		container.add(list);
		// panel.add(list);
		// container.add(panel);

		// get list
		ConnectionThread thread = new ConnectionThread(list);
		thread.start();

	}

	public static void main(String[] args) {
		ContactsGui gui = new ContactsGui();
		gui.setVisible(true);
	}
}
