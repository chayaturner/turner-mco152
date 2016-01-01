package turner.twitter;

import org.eclipse.jetty.server.Server;

public class TwitterJettyServer {

	public static void main(String[] args) throws Exception {

		Server server = new Server(8080); //port number
		server.setHandler(new TwitterHandler());
		
		server.start();
		server.join();
	}

}
