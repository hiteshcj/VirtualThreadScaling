import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegularThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        int numberOfTasks = 200;
        ExecutorService executor= Executors.newFixedThreadPool(200);
	      long start = System.currentTimeMillis();
        try {
            for ( int i=0; i < numberOfTasks; i++){
                executor.execute(new MyRunnable(i));                
            }
      	    executor.shutdown();
        }catch(Exception err){
            err.printStackTrace();
        }	
	}


}

class MyRunnable implements Runnable{
    int id;
    public MyRunnable(int i){
        this.id = i;
    }
    public void run(){
        try{
        	
    		long start = System.currentTimeMillis();
    		factorial(2000000000);
    		long finish = System.currentTimeMillis();
    		long timeElapsed = finish - start;
    		System.out.println(timeElapsed);
    		//System.out.println("Run: "+ Thread.currentThread().getName() + " Elapsed Time =" + timeElapsed);
        }catch(Exception err){
            err.printStackTrace();
        }
    }
    
    static int factorial(int n)
    {
        int res = 1, i;
        for (i = 2; i <= n; i++)
            res *= i;
        return res;
    }
}
