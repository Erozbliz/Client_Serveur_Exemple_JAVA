package yield_thread;

/**
 * https://www.tutorialspoint.com/java/lang/thread_yield.htm The
 * java.lang.Thread.yield() method causes the currently executing thread object
 * to temporarily pause and allow other threads to execute.
 *
 */
public class ThreadYield implements Runnable {

	Thread t;

	public ThreadYield(String str) {
		t = new Thread(this, str);
		// this will call run() function
		t.start();
	}

	public static void main(String[] args) {
		new ThreadYield("Thread 1");
		new ThreadYield("Thread 2");
		new ThreadYield("Thread 3");

	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			// yields control to another thread every 5 iterations
			if ((i % 5) == 0) {
				System.out.println(Thread.currentThread().getName() + "yielding control...");
				/*
				 * causes the currently executing thread object to temporarily
				 * pause and allow other threads to execute
				 */
				Thread.yield();
			}
		}
		 System.out.println(Thread.currentThread().getName() + " has finished executing.");
	}

}
