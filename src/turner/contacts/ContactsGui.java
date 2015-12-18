package turner.contacts;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class ContactsGui extends JFrame {

	private static final long serialVersionUID = 1L; // default

	JPanel panel;
	JList<Contact> list;

	public ContactsGui() {
		setTitle("Contacts");
		setSize(300, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container container = getContentPane();
		setLayout(new BorderLayout());
		panel = new JPanel(new BorderLayout());
		list = new JList<Contact>();
		container.add(panel);
		// get list and add it to to panel
		ConnectionThread thread = new ConnectionThread(list, panel);
		thread.start();

		// format names to display correctly (instead of default toString)??

	}

	public static void main(String[] args) {
		ContactsGui gui = new ContactsGui();
		//not showing up until it's resize??
		gui.setVisible(true);
	}
}
