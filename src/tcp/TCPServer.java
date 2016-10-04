package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Version Console modifié
 * https://systembash.com/
 * 
 * @author
 *
 */
public class TCPServer {

	public TCPServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String argv[]) throws Exception {
		System.out.println("--SERVEUR TCP (quit pour fermer)--");
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		boolean stop = false; // marquer stop pour stoper socket
		while (stop == false) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			System.out.println("Received: " + clientSentence);
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			outToClient.writeBytes(capitalizedSentence);
			if (clientSentence.equals("quit")) {
				stop = true;
			}
		}
		welcomeSocket.close();
		System.out.println("Socket Serveur close");
	}

}
