package turner.contacts;

import java.io.IOException;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ConnectionThread extends Thread {

	JList<String> list;

	public ConnectionThread(JList<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		try {
			ContactConnection connection = new ContactConnection();
			Contact[] contacts;
			contacts = connection.createConnection();
			// add data from json to the JList

			String[] contactNames = new String[contacts.length];
			for (int i = 0; i < contactNames.length; i++) {
				contactNames[i] = contacts[i].getName();
			}

			list.setListData(contactNames);

			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setLayoutOrientation(JList.VERTICAL);
			list.setVisibleRowCount(10);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
