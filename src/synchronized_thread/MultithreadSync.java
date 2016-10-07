package synchronized_thread;

/**
 * https://www.tutorialspoint.com/java/java_thread_synchronization.htm
 * 
 * @author Colombies
 *
 *         Here is a simple example which may or may not print counter value in
 *         sequence and every time we run it, it produces a different result
 *         based on CPU availability to a thread.
 */
public class MultithreadSync {

	public static void main(String args[]) {

		//----------------------------------------
		/*System.out.println("******* WITHOUT SYNC ********");
		PrintDemo PD = new PrintDemo();

		ThreadDemo T1 = new ThreadDemo("Thread - 1 ", PD);
		ThreadDemo T2 = new ThreadDemo("Thread - 2 ", PD);

		T1.start();
		T2.start();

		// wait for threads to end
		try {
			T1.join();
			T2.join();
		} catch (Exception e) {
			System.out.println("Interrupted");
		}*/
		
		//----------------------------------------

		System.out.println("******* WITH SYNC ********");
		PrintDemo PDsync = new PrintDemo();

		ThreadDemoSync T1sync = new ThreadDemoSync("Thread - 1 ", PDsync);
		ThreadDemoSync T2sync = new ThreadDemoSync("Thread - 2 ", PDsync);

		T1sync.start();
		T2sync.start();

		// wait for threads to end
		try {
			T1sync.join();
			T2sync.join();
		} catch (Exception e) {
			System.out.println("Interrupted");
		}

	}

}
