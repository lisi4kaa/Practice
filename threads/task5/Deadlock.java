package task5;

public class Deadlock {
	 private static final Object spoon1 = new Object();
	    private static final Object spoon2 = new Object();

	    public static void runDeadlock() {
	        Thread person1 = new Thread(() -> {
	            synchronized (spoon1) {
	                System.out.println("Человек 1 держит ложку 1");
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                System.out.println("Человек 1 пытается взять ложку 2");
	                synchronized (spoon2) {
	                    System.out.println("Человек 1 держит обе ложки");
	                }
	            }
	        });

	        Thread person2 = new Thread(() -> {
	            synchronized (spoon2) {
	                System.out.println("Человек 2 держит ложку 2");
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                System.out.println("Человек 2 пытается взять ложку 1");
	                synchronized (spoon1) {
	                    System.out.println("Человек 2 держит обе ложки");
	                }
	            }
	        });

	        person1.start();
	        person2.start();
	    }
	}