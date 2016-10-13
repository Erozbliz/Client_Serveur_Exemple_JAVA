package synchronized_thread;

public class ThreadSync extends Thread {

	static ThreadSync ts = new ThreadSync();
	private String[] tab = new String[50];
	private int index = 0;
	
	public ThreadSync() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]) {

			
		  Thread thread1 = new Thread(new Runnable() {
			     public void run() {
			          // code goes here.
			    	 ts.ajoute("eee");
			     }
			});  
		  
			
			Thread thread2 = new Thread(new Runnable() {
			     public void run() {
			          // code goes here.
			    	 System.out.println(ts.getPremierElementBloquant());
			     }
			});  
			
			
			thread2.start();
			thread1.start();
			
			/*try {
				thread1.join();
				thread2.join();
			} catch (Exception e) {
				System.out.println("Interrupted");
			}	*/	


	}



	/**
	 * 
	 * @param s
	 */
	synchronized void ajoute(String s) {
		tab[index] = s;
		index++;
		notify();
		System.out.println("notify() exécuté "+tab[0]);
	}

	/**
	 * 
	 * @return
	 */
	synchronized String getPremierElementBloquant() {
		// tant que la liste est vide
		while (index == 0) {
			try {
				// attente passive
				System.out.println("wait");
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		return tab[0];
	}

}
