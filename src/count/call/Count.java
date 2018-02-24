package count.call;

import java.util.concurrent.*;

public class Count implements Callable{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int sum=0;
        ExecutorService es= Executors.newFixedThreadPool(5);
        Future[] futures=new Future[10];
        for(int i=0;i<10;i++) {
            futures[i]=es.submit(new Count());
        }
        for(int i=0;i<10;i++){
            System.out.println( futures[i].isDone());
        }

    }

    int sum=0;
    @Override
    public Integer  call() throws InterruptedException {
        int sum=0;
        for(int i=0;i<101;i++){
            Thread.sleep(20);
            sum+=i;
        }
        return sum;
    }
    public int getSum(){
        return sum;
    }
}
