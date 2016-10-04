package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Version modifié
 * https://systembash.com/
 * 
 * @author
 *
 */
public class UDPServer {

	public UDPServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) throws Exception {
		System.out.println("--SERVEUR--");
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		boolean stop = false; // marquer stop pour stoper socket
		while (stop == false) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			// String sentence = new String( receivePacket.getData());
			// On récupere que le contenu
			String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
			System.out.println("RECEIVED: " + sentence);
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String capitalizedSentence = sentence.toUpperCase();
			sendData = capitalizedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
			if (sentence.equals("quit")) {
				stop = true;
			}
		}
		serverSocket.close();
		System.out.println("Socket Serveur close");
	}

}
