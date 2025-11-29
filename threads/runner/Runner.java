package runner;

import task1.Counter;
import task2.BigArray;
import task3.SearchMaxElement;
import task4.TimerThread;
import task4.Stopper;
import task5.Deadlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
	public static void main(String [] args) {
		
		System.out.println("\nЗадание 1");
		Counter.counter();
		
		System.out.println();
		System.out.println("\nЗадание 2");
		int[] data = new int [100000000];
		Arrays.fill(data, 1);
		BigArray.oneThread(data);
		BigArray.manyThreads(data);
		
		System.out.println();
		System.out.println("\nЗадание 3");
		List<Integer> data1 = new ArrayList<>(100000000);
		for (int i = 0; i < 100000000; i++) {
		    data1.add(1);
		}
		data1.add(2);
		SearchMaxElement.oneThread(data1);
		SearchMaxElement.manyThreads(data1);	
		
		System.out.println();
		System.out.println("\nЗадание 4");
		TimerThread t = new TimerThread(); 
		Thread timer = new Thread(t);
		Stopper s = new Stopper(timer);
		Thread stop = new Thread(s);
		timer.start();
		stop.start();
		
		System.out.println();
		System.out.println("\nЗадание 5");
        DeadlockDemo.runDeadlock();
	}
}
