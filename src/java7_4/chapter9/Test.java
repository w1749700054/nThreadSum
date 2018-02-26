package java7_4.chapter9;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor executor= (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Task task=new Task();
        System.out.println("Main:Executing Task");
        Future<String> future=executor.submit(task);
        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cancel the task");
        future.cancel(true);
        System.out.printf("Main:cancel:%s\n",future.isCancelled());
        System.out.printf("Main :done :%s\n",future.isDone());
        executor.shutdown();
        System.out.println("the end");
    }
}
