import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class VirtualThreadExecutorExample {

    public static void main(String[] args) {
        // Create an ExecutorService that uses virtual threads
      	int numberOfTasks = 200;
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Submit a Runnable task to the executor
    	      for ( int i=0; i < numberOfTasks; i++){
                Future<?> future = executor.submit(() -> {
                   long start = System.currentTimeMillis();
        		       factorial(2000000000);
        		       long finish = System.currentTimeMillis();
        		       long timeElapsed = finish - start;
        		       System.out.println(timeElapsed);
    	          });
    	      }
        } // The try-with-resources block ensures the executor is shut down
    }
    static int factorial(int n)
    {
        int res = 1, i;
        for (i = 2; i <= n; i++)
            res *= i;
        return res;
    }
}
