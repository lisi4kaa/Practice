package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SearchMaxElement {
	
	public static void oneThread(List<Integer> data ) {
		int max = 0;
		long start = System.currentTimeMillis();

		for(int i =0; i<data.size(); i++) {
			if (data.get(i)>max){
				max=data.get(i);	
			}
		}
		long end = System.currentTimeMillis();
		long time = end-start;
		
		System.out.println("Один поток справился за: "+ time + " мс, и получил максимальное значение: " + max);
	}
	
	public static void manyThreads(List<Integer> data) {
		int max =0;
		int n = 4;
		int part = (data.size()+n-1)/n;
		List<Future<Integer>> res =new ArrayList<>();
		
		ExecutorService s = Executors.newFixedThreadPool(n);
		long start = System.currentTimeMillis();
		
		for(int i =0; i<n; i ++) {
			int first = i*part;
			int last = Math.min(first+part, data.size());
			
			res.add(s.submit(() ->{
				int localmax = 0;
				for(int j = first; j<last;j++) {
					if (data.get(j)>localmax){
						localmax=data.get(j);	
					}
				}
				return localmax;
			}));
		}
		try {
			
		for (Future<Integer> r : res) {
				max=Math.max(max, r.get()); 
		}
		} catch (InterruptedException e) {
			System.out.println("Ошибка :" + e.getMessage());
		} catch (ExecutionException e) {
			System.out.println("Ошибка :" + e.getMessage());
		}
			
		long end = System.currentTimeMillis();
		long time = end-start;
		
		System.out.println(n + " поток(а)(ов) справился за: "+ time + " мс, и максимальное значение: " + max);
		
		s.shutdown();
	}
}
