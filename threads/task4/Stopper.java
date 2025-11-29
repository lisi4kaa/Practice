package task4;

public class Stopper implements Runnable {
	private Thread timer;
	
	public Stopper(Thread timer) {
		this.timer=timer;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(15000);
				timer.interrupt();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
