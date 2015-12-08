package turner.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHttpRequestDemo {

	public static void main (String [] args) throws UnknownHostException, IOException{
		//open socket
		Socket socket = new Socket("www.google.com", 80); 
		//request - the http protocol - the http part of the url.
		String httpRequestString = "GET /index.html\n\n";
		//get outputstream of socket and write this string to the socket
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		//write to the socket via outputstream
		out.write(httpRequestString);
		//always flush
		out.flush();
		
		//response- 
		InputStream in = socket.getInputStream();
		//read from inputstream
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(in));
		String s;
		while((s = reader.readLine()) != null){
			System.out.println(s);
		}
		
		socket.close();
		
		
	}
}
