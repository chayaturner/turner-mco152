package turner.chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.jetty.server.Server;

public class ChatWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private final JTextField text;
	private final JTextArea area;
	private final JButton button;
	private final JPanel panel;
	// private final JScrollPane scroll;

	public ChatWindow() {
		setTitle("Chat Window");
		setSize(450, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		area = new JTextArea();
		text = new JTextField(30);
		button = new JButton("Send:");

		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(text);
		panel.add(button);
		// scroll = new JScrollPane(area);
		// add(scroll, BorderLayout.CENTER);
		add(area, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		// connect to other's server through a url of ip address.
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = new URL("http://192.168.117.111:8080");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);
					OutputStream out = connection.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					writer.println(text.getText());

					writer.flush(); // tell writer you are done writing before
									// sending

					connection.getInputStream();

				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		// create a server to handle the request
		Server server = new Server(8080);
		server.setHandler(new ChatP2PHandler(area));
		try {
			server.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatWindow().setVisible(true);
	}

}
