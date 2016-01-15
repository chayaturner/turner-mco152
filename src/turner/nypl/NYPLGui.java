package turner.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class NYPLGui extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton searchButton;
	private JButton previousButton;
	private JButton nextButton;
	private JPanel centerPanel;
	private JPanel northPanel;
	private JPanel left;
	private JPanel top;
	private JTextField textField;
	private JList<String> list;
	JScrollPane listScroller;

	public NYPLGui() {

		setTitle("NYPL Search");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		textField = new JTextField(30);
		northPanel = new JPanel();
		northPanel.add(textField);
		container.add(northPanel);
		searchButton = new JButton("Search");
		container.add(searchButton);
		previousButton = new JButton("Previous");
		nextButton = new JButton("Next");
		centerPanel = new JPanel();
		centerPanel.setAlignmentX(CENTER_ALIGNMENT);
		left = new JPanel();
		list = new JList<String>();

		// add scroll to list
		listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(300, 300));

		// add single selection to list
		list.setModel(new DefaultListModel<String>());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		left.add(list);
		left.setAlignmentX(LEFT_ALIGNMENT);
		top = new JPanel();
		top.setAlignmentX(TOP_ALIGNMENT);
		top.setLayout(new FlowLayout());
		top.add(previousButton);
		top.add(nextButton);
		centerPanel.add(top);
		centerPanel.add(left);
		container.add(centerPanel);

		searchButton.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				String search = textField.getText();
				ConnectionThread thread = new ConnectionThread(list, search);
				thread.start();
			}
		});

	}

	public static void main(String[] args) {
		NYPLGui gui = new NYPLGui();
		gui.setVisible(true);
	}
}
