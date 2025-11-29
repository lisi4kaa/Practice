package task4;

public class TimerThread implements Runnable {
	public void run() {
		while(true) {
			try {
				Thread.sleep(5000);
				System.out.println("Сообщение от первого потока");
			} catch (InterruptedException e) {
				System.out.println("Первый поток был прерван");
				break;
			}
		}
	}	
}