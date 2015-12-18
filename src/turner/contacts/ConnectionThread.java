package turner.contacts;

import java.io.IOException;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class ConnectionThread extends Thread {

	JList<Contact> list;
	JPanel panel;

	public ConnectionThread(JList<Contact> list, JPanel panel) {
		this.list = list;
		this.panel = panel;
	}

	public void run() {
		try {
			ContactConnection connection = new ContactConnection();
			Contact[] contacts;
			contacts = connection.createConnection();
			// add data from json to the JList
			JList<Contact> list = new JList<Contact>(contacts);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setLayoutOrientation(JList.VERTICAL);
			list.setVisibleRowCount(10);

			// list needs to be formatted to display the names correctly

			panel.add(list);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
