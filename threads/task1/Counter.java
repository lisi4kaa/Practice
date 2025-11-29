package task1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	public static void counter() {
		try {
			ExecutorService s = Executors.newFixedThreadPool(3);
			
			AtomicInteger x = new AtomicInteger(0);
			for(int i =0; i<5;i++) {
			Future <?> res = s.submit(()->{return x.addAndGet(1);
			});
			
			System.out.println(res.get()); // вывод состояния переменной на каждой итерации
			}
			
			s.shutdown();
			
			s.awaitTermination(1, TimeUnit.SECONDS); // ждем завершения текущего потока main максимум 1 секунду
			System.out.println(x.get()); // итоговый вывод
			
		} catch (InterruptedException e) {
			System.out.println("Ошибка :" + e.getMessage());
		} catch (ExecutionException e) {
			System.out.println("Ошибка :" + e.getMessage());
		}
	}
}
