package tcpThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  http://www.jmdoudoux.fr/
 * L'inconvénient de ce modèle est qu'il ne peut traiter qu'une 
 * connexion à la fois. Pour pouvoir traiter plusieurs 
 * connexions simultanément, il faut créer un nouveau thread
 *  contenant les traitements à réaliser sur la socket.
 * @author Colombies
 *
 */
public class TestServeurTCP {
	final static int port = 9632;

	  public static void main(String[] args) {
	    try {
	      ServerSocket socketServeur = new ServerSocket(port);
	      System.out.println("Lancement du serveur");

	      while (true) {
	        Socket socketClient = socketServeur.accept();
	        String message = "";

	        System.out.println("Connexion avec : "+socketClient.getInetAddress());

	        // InputStream in = socketClient.getInputStream();
	        // OutputStream out = socketClient.getOutputStream();

	        BufferedReader in = new BufferedReader(
	          new InputStreamReader(socketClient.getInputStream()));
	        PrintStream out = new PrintStream(socketClient.getOutputStream());
	        message = in.readLine();
	        out.println(message);

	        socketClient.close();
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

}
