package monitor;


/**
 * Exemple modele des moniteurs 
 *
 */
public class ModelMonitor {

private Object lock = new Object();
	
	public static void main(String[] args) {
		final ModelMonitor moniteur = new ModelMonitor();
		
		Runnable task1 = new Runnable(){
			@Override
			public void run() {
				moniteur.waitingForCondition("task1");			
			}
		};

		Runnable task2 = new Runnable(){
			@Override
			public void run() {
				moniteur.waitingForCondition("task2");			
			}
		};
		Runnable task3 = new Runnable(){
			@Override
			public void run() {
				moniteur.satisfyingCondition("task3");			
			}
		};
	
		new Thread(task1).start();
		//new Thread(task2).start();
		new Thread(task3).start();
		
	}
	
	public void waitingForCondition(String threadName) {
		System.out.println("entering waitingForCondition : " + threadName);
		System.out.println("requesting lock : " + threadName);
		synchronized(lock) {
			System.out.println("lock acquired : " + threadName);
			System.out.println("waiting for condition : " + threadName);
			try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("condition satisfied : " + threadName);
			System.out.println("releasing lock : " + threadName);
		}
		System.out.println("lock released: " + threadName);	
	}

	public void satisfyingCondition(String threadName) {
		System.out.println("entering satisfyingCondition : " + threadName);
		System.out.println("requesting lock : " + threadName);
		synchronized(lock) {
			System.out.println("lock acquired : " + threadName);
			System.out.println("satisfying condition -- notifyAll : " + threadName);
			lock.notifyAll();
			System.out.println("continuing after notifyAll : " + threadName);
			System.out.println("releasing lock : " + threadName);
		}
		System.out.println("lock released: " + threadName);	
	}


}
