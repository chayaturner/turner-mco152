package turner.nypl;

import java.io.IOException;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ConnectionThread extends Thread {

	JList<String> list;
	String text;

	ConnectionThread(JList<String> list, String text) {
		this.list = list;
		this.text = text;
	}

	@Override
	public void run() {
		try {
			NYPLConnection connection = new NYPLConnection();
			RequestAPI api = connection.createConnection(text);

			String[] apiString = new String[api.getResult().getItems().length];
			// get titles and set list:
			for (int i = 0; i < apiString.length; i++) {
				apiString[i] = api.getResult().getItems()[i].getTitle();
			}

			list.setListData(apiString);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setLayoutOrientation(JList.VERTICAL);
			list.setVisibleRowCount(20);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
