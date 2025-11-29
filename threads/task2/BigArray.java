package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BigArray {
	
	public static void oneThread(int[] data) {
		int sum =0;
		long start = System.currentTimeMillis();

		for(int i =0; i<data.length; i++) {
			sum+=data[i];
		}
		long end = System.currentTimeMillis();
		long time = end-start;
		
		System.out.println("Один поток справился за: "+ time + " мс, и получил итоговую сумму: " + sum);
	}
	
	public static void manyThreads(int[] data) {
		int sum =0;
		int n = 4;
		int part = (data.length+n-1)/n;
		List<Future<Integer>> res =new ArrayList<>();
		
		ExecutorService s = Executors.newFixedThreadPool(n);
		long start = System.currentTimeMillis();
		
		for(int i =0; i<n; i++) {
			int first = i*part;
			int last = Math.min(first+part, data.length);
			
			res.add(s.submit(() ->{
				int localsum = 0;
				for(int j = first; j<last;j++) {
					localsum+=data[j];
				}
				return localsum;
			}));
		}
		try {
			
		for (Future<Integer> r : res) {
				sum += r.get();
		}
		} catch (InterruptedException e) {
			System.out.println("Ошибка :" + e.getMessage());
		} catch (ExecutionException e) {
			System.out.println("Ошибка :" + e.getMessage());
		}
			
		long end = System.currentTimeMillis();
		long time = end-start;
		
		System.out.println(n + " поток(а)(ов) справился за: "+ time + " мс, и получил итоговую сумму: " + sum);
		
		s.shutdown();
	}
	
}
