package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Version Console modifié https://systembash.com/
 * 
 * @author
 *
 */
public class TCPClient {

	public TCPClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String argv[]) throws Exception {
		System.out.println("--CLIENT TCP (quit pour fermer)--");
		String sentence;
		String modifiedSentence;

		Socket clientSocket = new Socket("localhost", 6789);
		boolean stop = false; // marquer stop pour stoper socket
		//problem
		while (stop == false) {

			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

			sentence = inFromUser.readLine();
			outToServer.writeBytes(sentence + '\n');
			modifiedSentence = inFromServer.readLine();
			System.out.println("FROM SERVER: " + modifiedSentence);
			outToServer.flush();
		

		}
		clientSocket.close();
	}

}
